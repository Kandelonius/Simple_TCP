package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTread implements Runnable {

    private Socket socket;

    public ServerTread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            System.out.println("Client has connected.");
            // I/O buffers
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
                true);

            outSocket.println("Welcome what's your name?"); // sends welcome message to client
            String message = in_socket.readLine();
            System.out.println("Client says: " + message);

            socket.close();
            System.out.println("Socket is closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
