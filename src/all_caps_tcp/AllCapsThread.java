package all_caps_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AllCapsThread implements Runnable {

    private Socket socket;

    private AllCapsServer allCapsServer;

    public AllCapsThread(
        Socket socket,
        AllCapsServer allCapsServer) {
        this.socket = socket;
        this.allCapsServer = allCapsServer;
    }

    @Override
    public void run() {

        try {

            int clientNumber = allCapsServer.getClientNumber();

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
