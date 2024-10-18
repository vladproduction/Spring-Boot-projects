package com.vladproduction.archunitspringboot.service;

import com.vladproduction.archunitspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> personList = new ArrayList<>();
    public void create(Person person){
        personList.add(person);
    }

    public Person getByName(String name){
        for (Person person : personList) {
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

}
