package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTread implements Runnable {

    private Socket socket;

    private ServerMain serverMain;

    public ServerTread(
        Socket socket,
        ServerMain serverMain) {
        this.socket = socket;
        this.serverMain = serverMain;
    }

    @Override
    public void run() {

        try {

            int clientNumber = serverMain.getClientNumber();

            System.out.println("Client " + clientNumber + " has connected.");
            // I/O buffers
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
                true);

            outSocket.println("Welcome you are client number " + clientNumber + " what's your name? "); // sends welcome message to client
            String message = inSocket.readLine();
            System.out.println("Client says: " + message);

            socket.close();
            System.out.println("Client " + clientNumber + " has disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
