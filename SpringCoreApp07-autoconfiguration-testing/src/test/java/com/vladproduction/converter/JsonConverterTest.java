package com.vladproduction.converter;

import com.vladproduction.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonConverterTest {
    @Autowired
    private Converter jsonConverter;

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
    public void jsonConverterTest(){
        String jsonExpected = "[{\"name\":\"Jack\",\"age\":23},{\"name\":\"John\",\"age\":24}]";
        String jsonActual = jsonConverter.convert(personList);

        assertEquals(jsonExpected, jsonActual);
    }

}