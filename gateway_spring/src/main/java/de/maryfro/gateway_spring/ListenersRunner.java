package de.maryfro.gateway_spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ListenersRunner implements ApplicationRunner {
private final ClientGatewayTCP clientGatewayTCP;
    private final BalancerGatewayUDP balancerGatewayUDP;

    public ListenersRunner(ClientGatewayTCP clientGatewayTCP, BalancerGatewayUDP balancerGatewayUDP) {
        this.clientGatewayTCP = clientGatewayTCP;
        this.balancerGatewayUDP = balancerGatewayUDP;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clientGatewayTCP.run();
        balancerGatewayUDP.run();
    }
}
