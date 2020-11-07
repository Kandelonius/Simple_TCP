package simple_udp_modified;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SenderMod {

    public SenderMod() throws Exception {

        DatagramSocket socket = new DatagramSocket();
        Scanner stdIn = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your message: ");
            String message = stdIn.nextLine();
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer,
                buffer.length,
                InetAddress.getByName("127.0.0.1"),
                2020);

            socket.send(packet);
            System.out.println("Sent: " + message);

            buffer = new byte[1500];
            packet = new DatagramPacket(buffer,
                buffer.length);
            socket.receive(packet);

            message = new String(buffer).trim();
            System.out.println("Received: " + message);
        }
    }

    public static void main(String[] args) {
        try {
            new SenderMod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
