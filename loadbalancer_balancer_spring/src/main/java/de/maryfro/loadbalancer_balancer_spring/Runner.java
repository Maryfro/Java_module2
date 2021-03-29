package de.maryfro.loadbalancer_balancer_spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    Sender sender;
    Receiver receiver;
    Cleaner cleaner;


    public Runner(Sender sender, Receiver receiver, Cleaner cleaner) {
        this.sender = sender;
        this.receiver = receiver;
        this.cleaner = cleaner;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.run();
        receiver.run();
        cleaner.run();
    }
}
