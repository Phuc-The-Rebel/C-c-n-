
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class IncomingReader implements Runnable {

    Socket sock;
    private boolean isRSAKeySent = false;
    private boolean isAESKeySent = false;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    PublicKey clientPublicKey;
    PrivateKey privateKey;
    PublicKey serverPublicKey;
    SecretKey AESKey;
    Client clientForm;
    private class MessageType {

        final static int RSA_TYPE = 0;
        final static int AES_TYPE = 1;
        final static int DATA_TYPE = 2;
        final static int GET_PRODUCT_LIST = 3;
        final static int GET_ONE_PRODUCT = 4;
    }

    public IncomingReader(Client clientInstance,Socket sock, PublicKey clientPublicKey, PrivateKey privateKey, PublicKey serverPublicKey, SecretKey AESKey) {
        InputStream in = null;
        try {
            this.sock = sock;
            this.clientPublicKey = clientPublicKey;
            this.serverPublicKey = serverPublicKey;
            this.AESKey = AESKey;
            this.clientForm=clientInstance;
            in = sock.getInputStream();
            dataInputStream = new DataInputStream(in);
            OutputStream outputStream = sock.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
        } catch (Exception ex) {
            Logger.getLogger(IncomingReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendRSAKey() throws IOException {
      
        OutputStream outputStream = sock.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);
        byte[] bytesToSend = this.clientPublicKey.getEncoded();
        dataOutputStream.writeInt(bytesToSend.length);
        dataOutputStream.writeInt(MessageType.RSA_TYPE);
        dataOutputStream.write(bytesToSend);
        dataOutputStream.flush();
        System.out.println("Da gui public key cua client den server");
    }

    private void sendAESKey() throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        //serverPublicKey=(PublicKey) new SecretKeySpec(txtServerPublicKey.getText().getBytes(), "RSA");
        cipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);
        byte[] encryptedData;
        encryptedData = cipher.doFinal(this.AESKey.getEncoded());

        OutputStream outputStream = sock.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);
        
        dataOutputStream.writeInt(encryptedData.length);
        dataOutputStream.writeInt(MessageType.AES_TYPE);
        dataOutputStream.write(encryptedData);
        dataOutputStream.flush();
        System.out.println("Da gui AES key den server");
        
    }

    private String decryptAESMessage(byte[] encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, AESKey);
            byte[] encrypted = cipher.doFinal(encryptedData);
            String strMessage = new String(encrypted, StandardCharsets.UTF_8);
            return strMessage;
        } catch (Exception ex) {
            System.out.println("Client.decryptAESMessage() " + ex.toString());
        }
        return null;
    }

    public void run() {
        String message;
        try {
            while (true) {
                if (isRSAKeySent == false) {
                    sendRSAKey();
                    clientForm.EnableButtons();
                    isRSAKeySent = true;
                }
                int len = dataInputStream.readInt();
                
                byte[] encryptedData = new byte[len];
                int messageType = dataInputStream.readInt();
                System.out.println("messageType=" + messageType);
                if (messageType == MessageType.RSA_TYPE) {
                    System.out.println("Da nhan public key cua server");
                    dataInputStream.readFully(encryptedData);
                    KeyFactory kf = KeyFactory.getInstance("RSA"); // or "EC" or whatever
                    serverPublicKey = kf.generatePublic(new X509EncodedKeySpec(encryptedData));
                  
                    //Nếu chưa gửi thì thực hiện gửi AES key cho server
                    if (isAESKeySent == false) {
                        sendAESKey();
                        isAESKeySent = true;
                    }
                } else if (messageType == MessageType.GET_PRODUCT_LIST) {
                    System.out.println("Da nhan duoc danh sach san pham tu server");
                    // Decrypt the incoming message using the client's private key.
                    if (len > 0) {
                        dataInputStream.readFully(encryptedData);
                    }
                    String strProductList = decryptAESMessage(encryptedData);
                    
                    clientForm.FillTable(strProductList);
                }
                else if (messageType == MessageType.GET_ONE_PRODUCT) {
                    
                    
                    if (len > 0) {
                        dataInputStream.readFully(encryptedData);
                    }
                    // Giải mã bằng AES key
                    String strProductList = decryptAESMessage(encryptedData);                    
                    clientForm.showChart(strProductList);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // close run
}
