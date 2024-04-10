package com.vladproduction.globaltransaction2db.config;

/**
 * Created by vladproduction on 09-Apr-24
 */

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSourceConfig {

    @Bean
    public DataSource dataSourcePerson(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_person");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }

    @Bean
    public DataSource dataSourceUser(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_user");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }

}

