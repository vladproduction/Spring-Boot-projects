package com.app.vp.springsecurityjwtmysqljdbc.repository;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository{

    @Autowired
    private DataSource dataSource;

    public void createUser(User user){
        String sql = "insert into user (name, password, email) values (?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
