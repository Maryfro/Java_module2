import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class LoadReceiver implements Runnable {
    private final static int UDP_PORT = 4000;
    private final int PACKET_SIZE = 1024;
    private String dataFromServer;

    public String getDataFromServer() {
        return dataFromServer;
    }

    @Override
    public void run() {

        DatagramSocket udpSocket = null;
        try {
            udpSocket = new DatagramSocket(UDP_PORT);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);
        while (true) {
            try {
                udpSocket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int serverPort = packetIn.getPort();
            String host = packetIn.getAddress().getHostName();
            String load = new String(dataIn, 0, packetIn.getLength());
            dataFromServer = host + ":" + serverPort + "." + load;
        }

    }
}
