package de.maryfro.loadbalancer_balancer_spring.config;

import de.maryfro.loadbalancer_balancer_spring.server.ServerSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class Config {


    @Bean
    ServerSource serverSource(){
        return new ServerSource();
    }




  /* @Bean()
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(3600); // wait an hour if necessary
        executor.setThreadNamePrefix("LoadBalancer-");
        executor.initialize();
        return executor;
    }*/

}
