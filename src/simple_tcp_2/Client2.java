package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public Client2() throws Exception {

        Socket socket = new Socket("localhost",
            2020);
        System.out.println("Successful connection to the server.");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
            true);
        Scanner stdIn = new Scanner(System.in);
        String userNumber;

        while ((inSocket.readLine()).startsWith("Guess")) {
            System.out.println("Server says: Guess a number [1 - 10].");
            userNumber = stdIn.nextLine();
            outSocket.println(userNumber);
        }

        System.out.println("You got it!!");

        socket.close();
        System.out.println("Socket closed.");
    }

    public static void main(String[] args) {
        try {
            new Client2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
