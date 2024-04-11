package com.vladproduction.connection2db.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Configuration
public class DataSourceConfig {

    @Bean(name = "bikeDataSource")
    @Primary
    public DataSource bikeDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_bike");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }

    @Bean(name = "carDataSource")
    public DataSource carDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_car");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }
}
