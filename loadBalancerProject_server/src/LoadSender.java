import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadSender implements Runnable {

    private final int tcpSelfPort;
    private final String balancerHost;
    private final int udpServerPort;
    private final AtomicInteger tcpConnectionsCounter;
    private final int sendingFrequency;

    public LoadSender(int tcpSelfPort, String balancerHost, int udpServerPort, AtomicInteger tcpConnectionsCounter, int sendingFrequency) {
        this.tcpSelfPort = tcpSelfPort;
        this.balancerHost = balancerHost;
        this.udpServerPort = udpServerPort;
        this.tcpConnectionsCounter = tcpConnectionsCounter;
        this.sendingFrequency = sendingFrequency;
    }

    @Override
    public void run() {

        try {
            InetAddress inetAddress = InetAddress.getByName(balancerHost);
            DatagramSocket udpSocket = new DatagramSocket();

            while (true) {
                Thread.sleep(sendingFrequency);
                String line = tcpConnectionsCounter.toString() + ":" + tcpSelfPort;
                System.out.println(line);

                byte[] outputData = line.getBytes();

                DatagramPacket packetOut = new DatagramPacket(
                        outputData,
                        outputData.length,
                        inetAddress,
                        udpServerPort);

                udpSocket.send(packetOut);

            }

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
