package com.vladproduction.springbootclrroomsapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class SpringBootClrRoomsAppApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootClrRoomsAppApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            LOG.info("Start Spring Boot Clr Rooms");

            ResponseEntity<List<Room>> response = restTemplate.exchange("http://localhost:8080/api/rooms",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });
            response.getBody().forEach(room -> {
                LOG.info(room.toString());
            });

            LOG.info("Finish Spring Boot Clr Rooms");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootClrRoomsAppApplication.class, args);
    }

}
