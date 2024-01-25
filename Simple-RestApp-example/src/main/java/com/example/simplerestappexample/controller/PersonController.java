package com.example.simplerestappexample.controller;

import com.example.simplerestappexample.model.Person;
import com.example.simplerestappexample.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@RequestBody @Valid Person person){
        service.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        return service.getPerson(id);
    }

    @GetMapping
    public List<Person> getPersonList(){
        return service.getPersonList();
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable int id){
        service.deletePersonById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }


}
