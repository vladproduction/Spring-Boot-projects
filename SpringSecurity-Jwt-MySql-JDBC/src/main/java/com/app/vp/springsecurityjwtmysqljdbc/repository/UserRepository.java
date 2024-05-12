package com.app.vp.springsecurityjwtmysqljdbc.repository;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Repository layer for User entity;
 * -using DataSource for connections to the db
 * */
@Repository
public class UserRepository{

    @Autowired
    private DataSource dataSource;

    /**
     * Standard CRUD method that create user in db
     * @param user User object
     * return void (but with status code in controller logic as 201(CREATED))
     * */
    public void createUser(User user){
        String sql = "insert into user (name, password, email) values (?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.execute(); //when we do select: execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Standard CRUD method that find user by username from db
     * @param username name for existing user as String
     * @return User object with setting (name and password)
     * */
    public User findByUsername(String username) {
        System.out.println("Username = " + username);
        String sql = "select * from user where name = ?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery(); //when we do select: executeQuery()
            User user = null;
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                user = new User();// we have to create new User, because it was defined before as null
                user.setName(name); //set name so we do not having any null
                user.setPassword(password); //set password so we do not having any null
            }
            return user; //created user and return
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
