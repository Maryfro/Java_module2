package de.maryfro.loadbalancer_balancer_spring;

import de.maryfro.loadbalancer_balancer_spring.server.ServerData;
import de.maryfro.loadbalancer_balancer_spring.server.ServerSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

@MessageEndpoint
public class Receiver  {
    private final int udp_port;
    ServerSource serverSource;

    public Receiver(@Value("${de.maryfro.loadbalancer_balancer_spring.balancer.udp.port}") int udp_port,
                    ServerSource serverSource) {
        this.udp_port = udp_port;
        this.serverSource = serverSource;
    }

    @Async
    public void run() throws Exception {
        System.out.println("Receiver is working");
        DatagramSocket udpSocket;
        try {
            udpSocket = new DatagramSocket(udp_port);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }
        int PACKET_SIZE = 1024;
        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);
        while (true) {
            try {
                udpSocket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }
            getServerData(packetIn, dataIn);
        }
    }

    void getServerData(DatagramPacket packetIn, byte[] dataIn) {
        String host = packetIn.getAddress().getHostName();
        System.out.println(host);
        String loadAndPort = new String(dataIn, 0, packetIn.getLength());
        String[] loadAndPortArr = loadAndPort.split(":");
        int load = Integer.parseInt(loadAndPortArr[0]);
        System.out.println(load);
        int serverPort = Integer.parseInt(loadAndPortArr[1]);
        System.out.println(serverPort + ":" + load);
        serverSource.update(new ServerData(host, serverPort, load, System.currentTimeMillis()),
                load);
    }


}
