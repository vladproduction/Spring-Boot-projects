package com.vladproduction.globaltransaction2db.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Configuration
public class UserDataSourceConfig {

    @Bean(name = "userDataSource")
    public DataSource userDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jta_user");
        dataSource.setUsername("root");
        dataSource.setPassword("11111111");
        return dataSource;
    }
}
