
import java.net.*;
import java.io.*;

public class DHClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8088;
        int p = 23;
        int g = 9;
        int a = 4;
        try (Socket client = new Socket(serverName, port)) {
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(Integer.toString(p)); 
            out.writeUTF(Integer.toString(g)); 
            double A = ((Math.pow(g, a)) % p); 
            out.writeUTF(Double.toString(A)); 
            System.out.println("From Client : Private Key = " + a);
            DataInputStream in = new DataInputStream(client.getInputStream());
            double serverB = Double.parseDouble(in.readUTF());
            double Adash = ((Math.pow(serverB, a)) % p); 
            System.out.println("Secret Key to perform Symmetric Encryption = " + Adash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
