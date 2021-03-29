package de.maryfro.loadbalancer_balancer_spring.server;


import java.util.ArrayDeque;
import java.util.Queue;

public class ServerSource {
    Queue<ServerData> source = new ArrayDeque<>();

    public synchronized void update(ServerData serverData, int load) {
        if (!source.contains(serverData)) {
            source.add(serverData);
        } else {
            serverData.setLoad(load);
            serverData.setLastUpdate(System.currentTimeMillis());
        }
    }
    public synchronized ServerData getBest() {
        return source.stream().min((o1, o2) -> -(o1.getLoad() - o2.getLoad())).orElse(null);
    }

    public synchronized void removeUnused(int millis) {
        source.removeIf(data -> System.currentTimeMillis() - data.getLastUpdate() > millis);
    }

    @Override
    public String toString() {
        return "ServerSource{" +
                "source=" + source +
                '}';
    }
}
