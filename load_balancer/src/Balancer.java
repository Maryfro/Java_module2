import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class Balancer {
    //Do we use String as serverName or instance of class server?
    private Map<Map<String, Integer>, Integer> content;

    public Balancer() throws IOException {

        // Will balancer get only the load or info about server as well? TODO Replace hard code with info about server
        Map<String, Integer> serv1 = new HashMap<>();
        serv1.put("Server1", 3000);
        Map<String, Integer> serv2 = new HashMap<>();
        serv2.put("Server2", 4200);
        Map<String, Integer> serv3 = new HashMap<>();
        serv3.put("Server3", 8080);
        content.put(serv1, receiveLoad());
        content.put(serv2, receiveLoad());
        content.put(serv3, receiveLoad());
    }

    //TODO check with server if this method works
    private Integer receiveLoad() throws IOException {
        DatagramSocket udpSocket = new DatagramSocket(4000);
        byte[] inputData = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(inputData, 1024);
        udpSocket.receive(packetIn);

        String fromServer = new String(inputData, 0, packetIn.getLength());
        return Integer.parseInt(fromServer);
    }

    private Map findOptimalServer() {
        Integer minLoad = content.values().stream().min(Integer::compareTo).orElseThrow();
        return (Map) content
                .entrySet()
                .stream()
                .filter(entry -> minLoad.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    //TODO check with gateway if this method works
    private void sendOptimalServerToGateway() throws IOException {
        Map<String, Integer> optimalServer = findOptimalServer();
        byte[] dataOut = optimalServer.toString().getBytes();


        // here we need address and port of gateway
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int gatewayPort = 3200;
        DatagramSocket udpSocket = new DatagramSocket();
        DatagramPacket packetOut = new DatagramPacket(dataOut,
                dataOut.length,
                inetAddress,
                gatewayPort);

        udpSocket.send(packetOut);
    }
}
