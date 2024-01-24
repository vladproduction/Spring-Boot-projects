package com.example.simplerestappexample.controller;

import com.example.simplerestappexample.model.Person;
import net.bytebuddy.description.method.ParameterList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void restApiTest(){
        List<Person> allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.isEmpty());

        //addPerson1
        Person p1 = new Person("name1", 1);
        ResponseEntity responseEntity1 = template.postForObject("/api", p1, ResponseEntity.class);
        //assertTrue(responseEntity1.getStatusCode().value() == 200);

        //addPerson2
        Person p2 = new Person("name2", 2);
        ResponseEntity responseEntity2 = template.postForObject("/api", p2, ResponseEntity.class);

        //addPerson3
        Person p3 = new Person("name3", 3);
        ResponseEntity responseEntity3 = template.postForObject("/api", p3, ResponseEntity.class);

        allPersons = template.getForObject("/api", List.class);
        assertFalse(allPersons.isEmpty());
        assertTrue(allPersons.size() == 3);

//        assertTrue(allPersons.contains(p1));
//        assertTrue(allPersons.contains(p2));
//        assertTrue(allPersons.contains(p3));

        template.delete("/api/1");
        allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.size() == 2);

        template.delete("/api");
        allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.size() == 0);

    }

}