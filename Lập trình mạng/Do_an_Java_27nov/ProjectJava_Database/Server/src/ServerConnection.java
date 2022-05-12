
import java.io.*;
import java.net.*;
import java.sql.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ServerConnection extends Thread {

    private Socket client_socket;
    Socket sock;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    ObjectOutputStream objectOutputStream;
    PublicKey clientPublicKey;
    PublicKey serverPublicKey;
    PrivateKey serverPrivateKey;
    SecretKey aesKey;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    private class MessageType {

        final static int RSA_TYPE = 0;
        final static int AES_TYPE = 1;
        final static int DATA_TYPE = 2;
        final static int GET_PRODUCT_LIST = 3;
        final static int GET_ONE_PRODUCT = 4;
    }

    public ServerConnection(Socket client_socket, PublicKey publicKey, PrivateKey privateKey, Connection con) throws IOException {
        try {
            this.client_socket = client_socket;
            this.serverPublicKey = publicKey;
            this.serverPrivateKey = privateKey;
            this.conn = con;
            dataInputStream = new DataInputStream(client_socket.getInputStream());
            dataOutputStream = new DataOutputStream(client_socket.getOutputStream());

        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

    }

    private void sendRSAKey() throws IOException {

        byte[] bytesToSend = this.serverPublicKey.getEncoded();
        OutputStream outputStream = client_socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeInt(bytesToSend.length);
        dataOutputStream.writeInt(MessageType.RSA_TYPE);
        dataOutputStream.write(bytesToSend);
        dataOutputStream.flush();
        
    }

    private String getProductList(String strProductID, String strProductDesc) throws SQLException {
        try {
            stmt = conn.createStatement();
            String strQuery = "select * from tblProducts a";
            if ((!strProductID.equals("null")) && strProductDesc.equals("null")) {
                strQuery = strQuery + " where productid='" + strProductID.trim() + "'";
            } else if ((strProductID.equals("null")) && (!strProductDesc.equals("null"))) {
                strQuery = strQuery + " where upper(a.ProductDesc) like '%" + strProductDesc.trim().toUpperCase() + "%'";
            } else if (!strProductID.equals("null") && !strProductDesc.equals("null")) {
                strQuery = strQuery + " where a.productid='" + strProductID.trim() + "' and upper(a.ProductDesc) like '%" + strProductDesc.trim().toUpperCase() + "%'";
            }
            strQuery = strQuery + " order by productid, str_to_date(a.crawldate,'%d-%M-%Y');";
            rs = stmt.executeQuery(strQuery);
            String strProduct = null;
            StringBuilder strBuild = new StringBuilder();
            //Nếu không tìm thấy sản phẩm nào
          
            if (!rs.isBeforeFirst()){
                strProduct = "null" + "@@@" + "null" + "@@@" + "null" + "@@@" + 0;
                strBuild.append(strProduct + "aaa");
            }
            while (rs.next()) {
                //Giữa các cột trong một dòng được phân cách bằng cụm 3 ký tự @@@.
                //Giữa các dòng với nhau được phân tách bằng 3 ký tự aaa. 
                strProduct = rs.getString("CrawlDate") + "@@@" + rs.getString("ProductID") + "@@@" + rs.getString("ProductDesc") + "@@@" + rs.getDouble("Price");
                strBuild.append(strProduct + "aaa");
            }
            strProduct = strBuild.toString();
            return strProduct;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;

    }

    private String getProductInfo(String strProductID) {
        try {
            stmt = conn.createStatement();
            String strQuery = "select * from tblProducts a";
            if (strProductID != null) {
                strQuery = strQuery + " where productid='" + strProductID.trim() + "'";
            }
            strQuery = strQuery + " order by productid, str_to_date(a.crawldate,'%d-%M-%Y');";
            rs = stmt.executeQuery(strQuery);
            String strProduct = null;
            StringBuilder strBuild = new StringBuilder();
            while (rs.next()) {
                strProduct = rs.getString("CrawlDate") + "@@@" + rs.getString("ProductID") + "@@@" + rs.getString("ProductDesc") + "@@@" + rs.getDouble("Price");
                strBuild.append(strProduct + "aaa");
            }
            strProduct = strBuild.toString();
            return strProduct;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;

    }

    private void sendEncryptedMessage(String strOriginalMessage, int Message_Type) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException {

        Cipher cipher = Cipher.getInstance("AES");
        byte[] iv = new byte[16];
        byte[] encryptedData;
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        encryptedData = cipher.doFinal(strOriginalMessage.getBytes("UTF-8"));
        String encrypted = new String(encryptedData);
        System.out.println("Du lieu duoc ma hoa : " + encrypted);
        int len = encryptedData.length;
        OutputStream outputStream = client_socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeInt(len);
        dataOutputStream.writeInt(Message_Type);  //Loại dữ liệu là data chứ không phải là key
        dataOutputStream.write(encryptedData);
        dataOutputStream.flush();
    }

    private String decryptAESMessage(byte[] encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(encryptedData);
            String strMessage = new String(encrypted, StandardCharsets.UTF_8);
            return strMessage;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    public void run() {

        try {
            while (client_socket.isConnected()) {

                int len = dataInputStream.readInt();
                byte[] encryptedData = new byte[len];
                int messageType = dataInputStream.readInt();
                if (messageType == MessageType.RSA_TYPE) {      //Get the client's public key
                    dataInputStream.readFully(encryptedData);
                    KeyFactory kf = KeyFactory.getInstance("RSA");
                    clientPublicKey = kf.generatePublic(new X509EncodedKeySpec(encryptedData));
                    System.out.println("Client public key=" + clientPublicKey.toString());
                    //Gửi public key của server cho client
                    sendRSAKey();

                } else if (messageType == MessageType.AES_TYPE) {      //Nếu message chứa AES key do client gửi
                    System.out.println("Da nhan duoc AES key do client gui");
                    dataInputStream.readFully(encryptedData);
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(Cipher.DECRYPT_MODE, serverPrivateKey);
                    byte[] encrypted = cipher.doFinal(encryptedData);
                    aesKey = new SecretKeySpec(encrypted, "AES");

                } else if (messageType == MessageType.GET_PRODUCT_LIST) {
                    if (len > 0) {
                        dataInputStream.readFully(encryptedData);
                    }
                    String strMessage = decryptAESMessage(encryptedData);
                    
                    String tmpResult[] = strMessage.split("@@@");
                    //tmpResult[0] chính là productID, tmpResult[1] là product description
                    String strProductList;
                    strProductList = getProductList(tmpResult[0], tmpResult[1]);
                    sendEncryptedMessage(strProductList, MessageType.GET_PRODUCT_LIST);
                    //  sendRSAKey();
                } else if (messageType == MessageType.GET_ONE_PRODUCT) {
                    if (len > 0) {
                        dataInputStream.readFully(encryptedData);
                    }
                    String strProductID = decryptAESMessage(encryptedData);
                    String strProductInfo = getProductInfo(strProductID);
                    sendEncryptedMessage(strProductInfo, MessageType.GET_ONE_PRODUCT);
                    System.out.println("Da gui thong tin san pham : " + strProductID);
                } else {
                    // Giải mã thông điệp test gửi từ client
                    if (len > 0) {
                        dataInputStream.readFully(encryptedData);
                    }
                    String strMessage = decryptAESMessage(encryptedData);
                    System.out.println("Da nhan duoc thong diep tu clien: " + strMessage);
                }
            }
        } catch (SocketException ex) {
            System.out.println("Mot client vua ngat ket noi den server");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
