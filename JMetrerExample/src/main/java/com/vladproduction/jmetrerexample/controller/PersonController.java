package com.vladproduction.jmetrerexample.controller;

import com.vladproduction.jmetrerexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 13-Mar-24
 */

@RestController
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("/person")
    public Person getPerson(){
        logger.info("===info start===".toUpperCase());
        Person person = new Person();
        person.setName("John");
        person.setAge(26);
        logger.info("===info finish===".toUpperCase());
        return person;
    }

}
