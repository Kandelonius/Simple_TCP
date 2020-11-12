package number_guesser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NumberGuesserClient {
    public NumberGuesserClient() throws Exception {

        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection to the server.");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner stdIn = new Scanner(System.in);
        String message = "";
        System.out.println("To quit type 'EXIT'");

        do {
            System.out.println("Welcome type a message to be capitalized.");
            message = stdIn.nextLine().toUpperCase();
            outSocket.println(message);
            message = inSocket.readLine();
            System.out.println("Result: " + message);
        } while (!message.equals("EXIT"));

        socket.close();
        System.out.println("Socket closed.");
    }
    public static void main(String[] args) {
        try {
            new NumberGuesserClient();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
