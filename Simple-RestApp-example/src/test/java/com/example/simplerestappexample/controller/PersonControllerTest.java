package com.example.simplerestappexample.controller;

import com.example.simplerestappexample.model.Constants;
import com.example.simplerestappexample.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.example.simplerestappexample.model.Constants.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void restApiTest(){
        List<Person> allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.isEmpty());

        //addPerson1
        Person p1 = new Person("name1", MIN+1);
        ResponseEntity<Void> responseEntity1 = template.postForEntity("/api", p1, Void.class);
        assertTrue(responseEntity1.getStatusCode().value() == CREATED.value());

        //addPerson2
        Person p2 = new Person("name2", MIN+2);
        ResponseEntity<Void> responseEntity2 = template.postForEntity("/api", p2, Void.class);
        assertTrue(responseEntity2.getStatusCode().value() == CREATED.value());

        //addPerson3
        Person p3 = new Person("name3", MIN+3);
        ResponseEntity<Void> responseEntity3 = template.postForEntity("/api", p3, Void.class);
        assertTrue(responseEntity3.getStatusCode().value() == CREATED.value());

        Person [] persons = template.getForObject("/api", Person[].class);
        assertFalse(persons.length == 0);
        assertTrue(persons.length == 3);

        assertTrue(persons[0].equals(p1));
        assertTrue(persons[1].equals(p2));
        assertTrue(persons[2].equals(p3));


        template.delete("/api/1");
        allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.size() == 2);

        template.delete("/api");
        allPersons = template.getForObject("/api", List.class);
        assertTrue(allPersons.size() == 0);

    }

    @Test
    public void positiveValidationTest(){
        Person person1 = new Person("John", MIN);
        ResponseEntity<Void> voidResponseEntity = template.postForEntity("/api", person1, Void.class);
        assertTrue(voidResponseEntity.getStatusCode().value() == CREATED.value());
    }

    @Test
    public void negativeValidationTest(){
        Person person1 = new Person("John", MIN-1);
        ResponseEntity<Void> voidResponseEntity = template.postForEntity("/api", person1, Void.class);
        assertTrue(voidResponseEntity.getStatusCode().value() == BAD_REQUEST.value(),
                "actual response code = " + voidResponseEntity.getStatusCode().value());
    }
}