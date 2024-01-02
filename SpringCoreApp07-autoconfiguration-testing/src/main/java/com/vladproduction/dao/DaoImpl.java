package com.vladproduction.dao;

import com.vladproduction.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.ResultSet;
import java.util.List;

@Repository
//@Scope(value = "prototype")
//@Scope(value = "singleton")
public class DaoImpl implements Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void myInit(){
        System.out.println("dao.init");
    }

    public void create(Person person){
        jdbcTemplate.update("insert into persons (name, age) values(?, ?)", person.getName(), person.getAge());
    }

    //lambda:
    public List<Person> findAll(){
        return jdbcTemplate.query("select * from persons", (ResultSet rs, int rowNum)->{
                return new Person(rs.getString("name"),rs.getInt("age"));
        });
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dao.destroy");
    }
}
