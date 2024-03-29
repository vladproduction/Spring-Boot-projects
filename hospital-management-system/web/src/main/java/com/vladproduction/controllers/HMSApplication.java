package com.vladproduction.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vladproduction on 29-Mar-24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.vladproduction.*"})
@EntityScan(basePackages = {"com.vladproduction.*"})
@EnableJpaRepositories(basePackages = {"com.vladproduction.*"})
public class HMSApplication {
    public static void main(String[] args) {

        SpringApplication.run(HMSApplication.class);

    }
}
