package number_guesser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NumberGuesserThread implements Runnable {

    private Socket socket;

    private NumberGuesserServer numberGuesserServer;

    public NumberGuesserThread(
        Socket socket,
        NumberGuesserServer numberGuesserServer) {
        this.socket = socket;
        this.numberGuesserServer = numberGuesserServer;
    }

    @Override
    public void run() {

        try {

            int clientNumber = numberGuesserServer.getClientNumber();

            System.out.println("Client " + clientNumber + " has connected.");
            // I/O buffers
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
                true);

            String message = "";

            while (!message.equals("EXIT")){
                message = inSocket.readLine();
                outSocket.println(message);
            }
            socket.close();
            System.out.println("Client " + clientNumber + " has disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
