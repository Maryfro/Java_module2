package de.maryfro.string_operations.config;

import de.maryfro.string_operations.OperationContext;
import de.maryfro.string_operations.service.operation.IStringOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableAsync
@Configuration
public class AppConfig {

    @Bean
    public OperationContext operationContext(List<IStringOperation> operations) {
        return new OperationContext(operations);
    }

    @Bean
    public PrintWriter writer() throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream("output.txt"));
    }

    @Bean()
    public Executor asyncExecutor() {
        return Executors.newFixedThreadPool(17);
    }


}
