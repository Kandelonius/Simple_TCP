package all_caps_tcp;

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
        String newMessage = "";

        do {
            outSocket.println("Enter a phrase to be capitalized!");
            message = inSocket.readLine();
            newMessage = message.toUpperCase();
        } while (!newMessage.equals(""));

        outSocket.println("You did it!!");
        System.out.println("Secret number is out. Exiting app.");

        socket.close();
        System.out.println("Socket is closed.");
    }



    public static void main(String[] args) {
        try {
            new AllCapsServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
