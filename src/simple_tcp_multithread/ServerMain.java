package simple_tcp_multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public ServerMain() throws Exception {
        int PORT = 2020;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Port " + PORT + " is now open.");


        // infinite loop waiting for a new connection
        while (true) {
            Socket socket = serverSocket.accept();
            ServerTread serverTread = new ServerTread(socket,
                this);
            Thread thread = new Thread(serverTread);
            thread.start();
        }
    }

    private int clientNumber = 1;

    public int getClientNumber() {
        return clientNumber++;
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
