package com.example.simplerestappexample.service;

import com.example.simplerestappexample.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final List<Person> personList = new ArrayList<>();
    public void addPerson(Person person){
        personList.add(person);
    }

    public Person getPerson(int id){
        return personList.get(id);
    }

    public List<Person> getPersonList(){
        return personList;
    }

    public void deletePersonById(int id){
        personList.remove(id);
    }

    public void deleteAll(){
        personList.clear();
    }
}
