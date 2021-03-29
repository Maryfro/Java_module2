package de.maryfro.loadbalancer_balancer_spring;

import de.maryfro.loadbalancer_balancer_spring.server.ServerSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Cleaner  {
    private final int timestamp;
    private final ServerSource source;

    public Cleaner(@Value("${de.maryfro.loadbalancer_balancer_spring.cleaner.timestamp}")int timestamp, ServerSource source) {
        this.timestamp = timestamp;
        this.source = source;
    }


    @Async
    public void run() throws Exception {
        while (true) {
            source.removeUnused(timestamp);
            System.out.println(source);
            System.out.println("Cleaner is working");
            try {
                Thread.sleep(timestamp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
