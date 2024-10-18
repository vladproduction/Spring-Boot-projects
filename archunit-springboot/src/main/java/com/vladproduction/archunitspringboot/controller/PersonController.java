package com.vladproduction.archunitspringboot.controller;

import com.vladproduction.archunitspringboot.model.Person;
import com.vladproduction.archunitspringboot.model2.Car;
import com.vladproduction.archunitspringboot.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

//    private Car car;

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        personService.create(person);
    }

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personService.getByName(name);
    }
}
