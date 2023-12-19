package com.vladproduction.processor;

import com.vladproduction.converter.Converter;
import com.vladproduction.dao.Dao;
import com.vladproduction.model.Person;

import java.util.List;

public class Processor2 {

    private Dao dao;
    private Converter converter;

    public Processor2(Dao dao, Converter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    public String process(){
        List<Person> personList = dao.findAll();
        return converter.convert(personList);
    }
}
