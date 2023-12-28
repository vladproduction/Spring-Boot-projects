package com.vladproduction.converter;

import com.vladproduction.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class XmlConverterTest {

    @Autowired
    private Converter xmlConverter;

    List<Person> personList;

    @BeforeEach
    public void init(){
        Person person1 = new Person("Jack", 23);
        Person person2 = new Person("John", 24);
        personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
    }

    @Test
    public void xmlConverterTest(){
        String xmlExpected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><persons><Person><name>Jack</name><age>23</age></Person><Person><name>John</name><age>24</age></Person></persons>";
        String xmlActual = xmlConverter.convert(personList);

        assertEquals(xmlExpected, xmlActual);
    }

}