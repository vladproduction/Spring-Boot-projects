package com.vladproduction.processor;

import com.vladproduction.dao.Dao;
import com.vladproduction.model.Person;
import com.vladproduction.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(ProcessorTestConfig.class)
public class ProcessorTest {

    @Autowired
    private Processor processor;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Dao dao;

    @BeforeEach
    public void init(){
        Utils.cleanup(dataSource);

        Person person1 = new Person("Jack", 23);
        Person person2 = new Person("John", 25);
        dao.create(person1);
        dao.create(person2);
    }

    @Test
    public void processorTest(){

        String actual = processor.process();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><persons><Person><name>Jack</name><age>23</age></Person><Person><name>John</name><age>25</age></Person></persons>";

        assertEquals(actual, expected);

    }

}
