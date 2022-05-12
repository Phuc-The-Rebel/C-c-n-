
import java.io.*;
import java.sql.*;
import java.net.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

public class Server {

    static PublicKey publicKey;
    static PrivateKey privateKey;
    static ServerSocket server;
    static Connection conn;
    static Socket socket;

    public static void main(String[] args) throws Exception {
        int port = 6789;
        server = new ServerSocket(port);
        System.out.println("Dang khoi tao may chu");
        generateKeys();
        String currentDirectory=System.getProperty("user.dir");
        try {
            System.out.println("Dang ket noi den co so du lieu");            
            BufferedReader br = new BufferedReader(new FileReader("ConnectionString.txt"));
            String strConnection = br.readLine();
            String strUser = br.readLine();
            String strPassword = br.readLine();
            
            conn = DriverManager.getConnection(strConnection, strUser, strPassword);
            //conn = DriverManager.getConnection(strConnection);
            System.out.println("Da ket noi thanh cong den co so du lieu");
        } catch (FileNotFoundException ex) {
            System.out.println("Khong tim thay file ConnectionString.txt trong thu muc " + currentDirectory);
        } catch (Exception ex) {
            System.out.println("Ket noi khong thanh cong, hay dam bao MySQL server da duoc khoi dong.");
            System.out.println(ex.toString());
        }
        // Socket s = server.accept();
        while (true) {
            socket = server.accept();
            System.out.println("Client da ket noi den server!");
            try {
                //Gọi class để xử lý các message gửi từ client
                new ServerConnection(socket, publicKey, privateKey, conn).start();

            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }

    }

    private static void generateKeys() {
        try {
            // Hàm sinh ra public key và private key của server
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstanceStrong();
            keyPairGenerator.initialize(2048, random);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
