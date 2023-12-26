package com.vladproduction.dao;

import com.vladproduction.model.Person;

import java.util.List;

public interface Dao {

    void create(Person person);
    List<Person> findAll();
}
