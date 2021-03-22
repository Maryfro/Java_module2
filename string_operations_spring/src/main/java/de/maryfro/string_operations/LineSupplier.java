package de.maryfro.string_operations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LineSupplier implements ApplicationRunner {
    private final String filename;
    private final LineHandler handler;

    public LineSupplier(@Value("${de.maryfro.string_operation.input.file.path}") String filename, LineHandler handler) {
        this.filename = filename;
        this.handler = handler;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                handler.handleString(line);
                System.out.println("handled line");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
