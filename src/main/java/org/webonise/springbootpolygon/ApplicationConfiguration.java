package org.webonise.springbootpolygon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.logging.Logger;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Logger logger() {
        return Logger.getLogger(Application.class.getName());
    }

    @Bean
    public Scanner input() {
        return new Scanner(System.in);
    }
}
