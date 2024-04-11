// DHServer.java
import java.net.*;
import java.io.*;

public class DHServer {
    public static void main(String[] args) throws IOException {
        int port = 8088;
        int b = 3; // Server's private key

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            try (Socket server = serverSocket.accept()) {
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                // Accepts the data from client
                DataInputStream in = new DataInputStream(server.getInputStream());
                double clientP = Double.parseDouble(in.readUTF()); // to accept p
                double clientG = Double.parseDouble(in.readUTF()); // to accept g
                double clientA = Double.parseDouble(in.readUTF()); // to accept A

                double B = ((Math.pow(clientG, b)) % clientP); // calculation of B
                double Bdash = ((Math.pow(clientA, b)) % clientP); // calculation of Bdash

                // Sends data to client
                OutputStream outToClient = server.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToClient);
                out.writeUTF(Double.toString(B)); // Sending B
                System.out.println("Secret Key to perform Symmetric Encryption = " + Bdash);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
