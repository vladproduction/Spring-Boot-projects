package com.vladproduction.dao;

import com.vladproduction.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private String url;
    private String login;
    private String pass;

    public DaoImpl(String url, String login, String pass) {
        this.url = url;
        this.login = login;
        this.pass = pass;
    }

    public void myInit(){
        System.out.println("dao.init");
    }

    @Override
    public void create(Person person) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into person (name, age) values(?, ?)");
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> findAll() {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("select * from persons");
            ResultSet resultSet = ps.executeQuery();
            List<Person> res = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                res.add(new Person(name, age));
            }
            return res;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, pass);
    }
}
