package reverse_string;

import java.net.ServerSocket;
import java.net.Socket;

public class RSServer {
    public RSServer() throws Exception {
        int PORT = 2020;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Port " + PORT + " is now open.");

        // infinite loop waiting for a new connection
        while (true) {
            Socket socket = serverSocket.accept();
            RSThread rSThread = new RSThread(socket,
                this);
            Thread thread = new Thread(rSThread);
            thread.start();
        }
    }

    private int clientNumber = 1;

    public int getClientNumber() {
        return clientNumber++;
    }

    public static void main(String[] args) {
        try {
            new RSServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
