package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static void debug(String message) {
        System.out.println(message);
    }

    @Bean
    ApplicationRunner run() {
        return arguments -> {
            System.out.println("*** logging the parameters");
            String[] args = arguments.getSourceArgs();
            for (String arg : args) {
                System.out.println("********* arg is " + arg);
            }
        };
    }

    public static void main(String... args) {
        debug("********* inside main class");
        for (String arg : args) {
            debug("********* arg is " + arg);
        }
        debug("********* initializing the context");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        debug("********* initialized context");
        debug("********* closing the context");
        applicationContext.close();
        debug("********* closed the context");
    }
}
