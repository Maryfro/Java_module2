package de.maryfro.gateway_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class ClientGatewayTCP {

    private final int tcpPort;
    ServerTask serverTask;


    public ClientGatewayTCP(@Value("${tcp.outer.port}") int tcpPort,
                            ServerTask serverTask) throws IOException {
        this.tcpPort = tcpPort;
        this.serverTask = serverTask;
    }

    @Async
    public void run() throws Exception {
        System.out.println("tcp listener is running");
        ServerSocket serverSocket = new ServerSocket(tcpPort);
        while (true) {
            Socket socketToClient = serverSocket.accept();
            System.out.println("Connected");
            serverTask.handleConnection(socketToClient);
        }
    }
}
