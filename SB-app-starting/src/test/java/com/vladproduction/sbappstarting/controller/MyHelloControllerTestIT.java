package com.vladproduction.sbappstarting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vladproduction on 11-Mar-24
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyHelloControllerTestIT {

    @Autowired

    private TestRestTemplate template;

    /**As well as mocking the HTTP request cycle, we can also use Spring Boot to write a simple full-stack integration test.
     * For example, instead of (or as well as) the mock test shown earlier, we could create the following test:*/

    @Test
    public void getHello(){
        ResponseEntity<String> response = template.getForEntity("/index", String.class);
        assertThat(response.getBody()).isEqualTo("MyHelloController Spring Boot!");
    }

}
