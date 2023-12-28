package com.vladproduction.utils;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Utils {


    public static void cleanup(DataSource dataSource){
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement deletePs = connection.prepareStatement("delete from persons");
            deletePs.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
