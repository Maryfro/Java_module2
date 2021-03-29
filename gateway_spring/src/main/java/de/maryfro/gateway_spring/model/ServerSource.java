package de.maryfro.gateway_spring.model;

import org.springframework.stereotype.Component;

@Component
public class ServerSource {

    ServerInfo optimalServer;

    public synchronized ServerInfo getOptimalServer() {
        return optimalServer;
    }

    public synchronized void updateOptimalServer(ServerInfo updates) {

        optimalServer = updates;
    }
}