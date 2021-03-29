package de.maryfro.gateway_spring;

import de.maryfro.gateway_spring.model.ServerInfo;
import de.maryfro.gateway_spring.model.ServerSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class BalancerGatewayUDP  {

    private int udpPort;
    private final int PACKET_SIZE = 1024;
    ServerSource serverSource;

    public BalancerGatewayUDP(ServerSource serverSource, @Value("${udp.balancer.port}") int udpPort) {
        this.serverSource = serverSource;
        this.udpPort = udpPort;
    }


    private ServerInfo getPortServer(String packet) {
        String[] portServerArray = packet.split(":");
        if (portServerArray != null) {
            String server = portServerArray[0];
            int port = Integer.parseInt(portServerArray[1]);
            ServerInfo serverInfo = new ServerInfo(server, port);
            System.out.println("Balancer " + server + " port " + port);
            return serverInfo;
        }
        return null;
    }


    @Async
    public void run() throws Exception {
        System.out.println("udp balancer listener");
        DatagramSocket serverUdpSocket = new DatagramSocket(udpPort);
        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);
        while (true) {
            serverUdpSocket.receive(packetIn);
            String line = new String(dataIn, 0, packetIn.getLength());
            ServerInfo serverInfo = getPortServer(line);
            if (serverInfo != null) {
                serverSource.updateOptimalServer(serverInfo);
            }
        }
    }
}
