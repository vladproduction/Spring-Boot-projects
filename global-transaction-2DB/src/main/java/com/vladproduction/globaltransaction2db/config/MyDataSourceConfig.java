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
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta1");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }

}

/**spring.datasource.url=jdbc:mysql://localhost:3306/bankapp
 spring.datasource.username=root
 spring.datasource.password=11111111*/
