package com.vladproduction.archunitspringboot.model;


import com.vladproduction.archunitspringboot.controller.PersonController;
import com.vladproduction.archunitspringboot.service.PersonService;

public class Person {

//    private PersonService personService;
//    private PersonController personController;
//
//    public Person(PersonService personService, PersonController personController, String name, int age) {
//        this.personService = personService;
//        this.personController = personController;
//        this.name = name;
//        this.age = age;
//    }

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
