package de.maryfro.gateway_spring;

import de.maryfro.gateway_spring.model.ServerInfo;
import de.maryfro.gateway_spring.model.ServerSource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

@Service
public class ServerTask {
    private final ServerSource serverSource;

    public ServerTask(ServerSource serverSource) {
        this.serverSource = serverSource;
    }

    @Async
    public void handleConnection(Socket socketFromClient) throws IOException {
        ServerInfo serverInfo = serverSource.getOptimalServer();
        String host = serverInfo.getHostname();
        int port = serverInfo.getPort();
        Socket socketToServer = new Socket(host, port);

        try (PrintStream toClient = new PrintStream(socketFromClient.getOutputStream());
             BufferedReader fromClient = new BufferedReader(new InputStreamReader(socketFromClient.getInputStream()));
             PrintStream toServer = new PrintStream(socketToServer.getOutputStream());
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));) {
            String lineFromClient;
            while ((lineFromClient = fromClient.readLine()) != null) {
                toServer.println(lineFromClient);
                String lineFromServer = fromServer.readLine();
                toClient.println(lineFromServer);
            }
            socketToServer.close();
        }
    }
}
