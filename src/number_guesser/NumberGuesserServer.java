package number_guesser;

import java.net.ServerSocket;
import java.net.Socket;

public class NumberGuesserServer {

    public NumberGuesserServer() throws Exception {
        int PORT = 2020;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Port " + PORT + " is now open.");

        // infinite loop waiting for a new connection
        while (true) {
            Socket socket = serverSocket.accept();
            NumberGuesserThread allCapsThread = new NumberGuesserThread(socket,
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
            new NumberGuesserServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
