package simple_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {

    public Receiver() throws Exception {
        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("Reciever is running.");
        Scanner stdIn = new Scanner(System.in);

        byte[] buffer = new byte[1500]; // MTU = 1500 maximum transition unit
        DatagramPacket packet = new DatagramPacket(buffer,
            buffer.length);

        socket.receive(packet); // receiving sender's message

        String message = new String(buffer).trim();
        System.out.println("Received: " + message);

        InetAddress senders_address = packet.getAddress();
        int senders_port = packet.getPort();

        System.out.println("Enter a message: ");
        message = stdIn.nextLine();
        buffer = message.getBytes();
        packet = new DatagramPacket(buffer,
            buffer.length,
            senders_address,
            senders_port);
        socket.send(packet);
        System.out.println("Sent: " + message);
    }

    public static void main(String[] args) {
        try {
            new Receiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
