package com.vladproduction.springtransactions.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * Created by vladproduction on 14-Mar-24
 */

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_transactions");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("11111111");

        return driverManagerDataSource;
    }
}
