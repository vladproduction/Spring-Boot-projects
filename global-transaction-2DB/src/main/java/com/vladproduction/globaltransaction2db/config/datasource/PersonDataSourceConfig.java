package com.vladproduction.globaltransaction2db.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Configuration
public class PersonDataSourceConfig {

    @Bean(name = "personDataSource")
    @Primary
    public DataSource personDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_person");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }
}
