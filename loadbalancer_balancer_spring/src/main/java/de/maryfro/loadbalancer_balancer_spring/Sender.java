package de.maryfro.loadbalancer_balancer_spring;

import de.maryfro.loadbalancer_balancer_spring.server.ServerSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class Sender  {
    private final int gateway_port;
    private final String gateway_host;
    private final ServerSource source;
    private final int timestampToSend;


    public Sender(@Value("${de.maryfro.loadbalancer_balancer_spring.gateway.udp.port}")int gateway_port,
                  @Value("${de.maryfro.loadbalancer_balancer_spring.gateway.host}") String gateway_host,
                  ServerSource source,
                  @Value("${de.maryfro.loadbalancer_balancer_spring.sender.timestamp}")int timestampToSend) {
        this.gateway_port = gateway_port;
        this.gateway_host = gateway_host;
        this.source = source;
        this.timestampToSend = timestampToSend;


    }

    @Async
    public void run() throws Exception {
        System.out.println("sender is working");
        try {
            InetAddress inetAddress = InetAddress.getByName(gateway_host);
            DatagramSocket udpSocket = new DatagramSocket();
            while (true) {
                if (source.getBest() == null)
                    continue;
                String portAndHost = source.getBest().getHost() + ":" + source.getBest().getPort();
                byte[] outputData = portAndHost.getBytes();
                DatagramPacket packetOut = new DatagramPacket(outputData,
                        outputData.length,
                        inetAddress,
                        gateway_port);
                udpSocket.send(packetOut);
                Thread.sleep(timestampToSend);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sending was successful");
    }
}
