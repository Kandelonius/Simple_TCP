package all_caps_tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class AllCapsServer {

    public AllCapsServer() throws Exception {
        int PORT = 2020;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Port " + PORT + " is now open.");

        // infinite loop waiting for a new connection
        while (true) {
            Socket socket = serverSocket.accept();
            AllCapsThread allCapsThread = new AllCapsThread(socket,
                this);
            Thread thread = new Thread(allCapsThread);
            thread.start();
        }
    }

    private int clientNumber = 1;

    public int getClientNumber() {
        return clientNumber++;
    }

    public static void main(String[] args) {
        try {
            new AllCapsServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
