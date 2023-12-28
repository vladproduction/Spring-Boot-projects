package com.vladproduction.dao;

import com.vladproduction.model.Person;
import com.vladproduction.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DaoImplTest {

    @Autowired
    private Dao dao;
    @Autowired
    private DataSource dataSource;

    @BeforeEach
    public void init(){
        Utils.cleanup(dataSource);
    }

    @Test
    public void daoTest(){
        Person person1 = new Person("Jack", 23);
        dao.create(person1);
        List<Person> personList = dao.findAll();

        assertEquals(personList.size(), 1);
        assertEquals(personList.get(0).getName(), person1.getName());
        assertEquals(personList.get(0).getAge(), person1.getAge());
    }

}