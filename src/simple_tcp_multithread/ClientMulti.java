package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMulti {

    public ClientMulti() throws Exception {

        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection to the server.");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner stdIn = new Scanner(System.in);

        String message = inSocket.readLine();
        System.out.println("Server says: " + message);
        message = stdIn.nextLine();
        outSocket.println(message);

        socket.close();
        System.out.println("Socket closed.");
    }
    public static void main(String[] args) {
        try {
            new ClientMulti();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
