package com.vladproduction.utils;

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

    public static void dropAndCreateTable(DataSource dataSource){
        try(Connection connection = dataSource.getConnection()){
            connection.prepareStatement("DROP TABLE IF EXISTS `persons`;" +
                    "CREATE TABLE `persons` (\n" +
                    "            `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` varchar(45) NOT NULL,\n" +
                    "  `age` int NOT NULL,\n" +
                    "    PRIMARY KEY (`id`))").execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
