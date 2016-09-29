package org.webonise.polygon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainHandler implements CommandLineRunner {

    @Autowired
    private Application application;

    @Override
    public void run(String... args) throws Exception {
        this.application.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(MainHandler.class, args);
    }
}
