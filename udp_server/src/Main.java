import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    private final static int UDP_SERVER_PORT = 3000;
    private final static int PACKET_SIZE = 1024;


    public static void main(String[] args) throws IOException {
        DatagramSocket udpSocket = new DatagramSocket(UDP_SERVER_PORT);

        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);
        while (true) {
            udpSocket.receive(packetIn);
            String line = new String(dataIn, 0, packetIn.getLength());

            String response = "Handled a datagram from the port: " + packetIn.getPort()
                    + " received data " + line;

            byte[] dataOUt = response.getBytes();
            DatagramPacket packetOut = new DatagramPacket(
                    dataOUt,
                    dataOUt.length,
                    packetIn.getAddress(),
                    packetIn.getPort());

            udpSocket.send(packetOut);
        }
    }
}
