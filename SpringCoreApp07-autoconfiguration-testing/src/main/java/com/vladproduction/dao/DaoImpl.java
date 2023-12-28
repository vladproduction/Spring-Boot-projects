package com.vladproduction.dao;

import com.vladproduction.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

//    @Override
//    public void create(Person person) {
//        try(Connection c = dataSource.getConnection()){
//            PreparedStatement ps = c.prepareStatement("insert into person (name, age) values(?, ?)");
//            ps.setString(1, person.getName());
//            ps.setInt(2, person.getAge());
//            ps.execute();
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//    }

    public void create(Person person){

        jdbcTemplate.update("insert into persons (name, age) values(?, ?)", person.getName(), person.getAge());

    }


//    @Override
//    public List<Person> findAll() {
//        try(Connection c = dataSource.getConnection()){
//            PreparedStatement ps = c.prepareStatement("select * from persons");
//            ResultSet resultSet = ps.executeQuery();
//            List<Person> res = new ArrayList<>();
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                res.add(new Person(name, age));
//            }
//            return res;
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//    }

//    public List<Person> findAllOld(){
//        return jdbcTemplate.query("select * from persons", new RowMapper<Person>() {
//            @Override
//            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new Person(name, age);
//            }
//        });
//    }

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
