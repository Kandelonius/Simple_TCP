package simple_tcp_multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public ServerMain() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open.");

        // infinite loop waiting for a new connection
        while (true) {
            Socket socket = serverSocket.accept();
            ServerTread serverTread = new ServerTread(socket);
            Thread thread = new Thread(serverTread);
            thread.start();
        }
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
