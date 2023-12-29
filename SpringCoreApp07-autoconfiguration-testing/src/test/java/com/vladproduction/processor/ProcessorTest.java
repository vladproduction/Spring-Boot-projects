package com.vladproduction.processor;

import com.vladproduction.dao.Dao;
import com.vladproduction.model.Person;
import com.vladproduction.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProcessorTest {

    @Autowired
    private Processor xmlProcessor;

    @Autowired
    private Processor jsonProcessor;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Dao dao;

    @BeforeEach
    public void init(){
        Utils.dropAndCreateTable(dataSource);
//        Utils.cleanup(dataSource);

        Person person1 = new Person("Jack", 23);
        Person person2 = new Person("John", 25);
        dao.create(person1);
        dao.create(person2);
    }

    @Test
    public void xmlProcessorTest(){
        String actual = xmlProcessor.process();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><persons><Person><name>Jack</name><age>23</age></Person><Person><name>John</name><age>25</age></Person></persons>";
        assertEquals(actual, expected);
    }

    @Test
    public void jsonProcessorTest(){
        String actual = jsonProcessor.process();
        String expected = "[{\"name\":\"Jack\",\"age\":23},{\"name\":\"John\",\"age\":25}]";
        assertEquals(actual, expected);
    }

}
