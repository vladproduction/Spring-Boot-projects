package com.vladproduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        // by default work(port:8080; file:application.properties)

//        System.setProperty("spring.profiles.active", "dev");
//        System.setProperty("spring.profiles.active", "prod");
//        System.setProperty("spring.profiles.active", "uat");
        SpringApplication.run(MainApp.class, args);
    }
}
