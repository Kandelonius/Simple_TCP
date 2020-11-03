package all_caps_tcp;

import simple_tcp_multithread.ServerMain;
import simple_tcp_multithread.ServerTread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AllCapsServer {

    public AllCapsServer() throws Exception {
        int PORT = 2020;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Port " + PORT + " is now open.");

        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");

        // I/O buffers
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
            true);
        String message;
        int secretNumber = (int)(Math.random() * 10 + 1);

        do {
            outSocket.println("Guess a number [1 - 10]: ");
            message = inSocket.readLine();
        } while (!(Integer.parseInt(message) == secretNumber));

        outSocket.println("You did it!!");
        System.out.println("Secret number is out. Exiting app.");

        socket.close();
        System.out.println("Socket is closed.");
    }



    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
