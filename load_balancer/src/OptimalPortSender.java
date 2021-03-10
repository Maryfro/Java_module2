import java.io.IOException;
import java.net.*;

public class OptimalPortSender implements Runnable {
    private final static int GATEWAY_PORT = 3001;
    private final static String UDP_HOST = "localhost";
    Balancer balancer = new Balancer();


    @Override
    public void run() {
        try {
            InetAddress inetAddress = InetAddress.getByName(UDP_HOST);
            DatagramSocket udpSocket = new DatagramSocket();
            String portAndHost = balancer.getContent().keySet().toString();
            byte[] outputData = portAndHost.getBytes();
            DatagramPacket packetOut = new DatagramPacket(outputData,
                    outputData.length,
                    inetAddress,
                    GATEWAY_PORT);
            udpSocket.send(packetOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
