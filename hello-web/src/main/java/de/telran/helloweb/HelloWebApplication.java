package de.telran.helloweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class HelloWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWebApplication.class, args);
    }

}
