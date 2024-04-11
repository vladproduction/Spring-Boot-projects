package com.vladproduction.springbootmultidatasource.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "accountEntityManagerFactory",
        transactionManagerRef = "accountTransactionManager",
        basePackages = {"com.vladproduction.springbootmultidatasource.accountdb.repository"}
)
public class AccountDataSourceConfig {

    @Bean(name = "accountDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.accountdb.datasource")
    public DataSource accountDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "accountEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("accountDataSource") DataSource accountDataSource
    ){
        return builder
                .dataSource(accountDataSource)
                .packages("com.vladproduction.springbootmultidatasource.accountdb.entity")
                .build();
    }

    @Bean(name = "accountTransactionManager")
    public PlatformTransactionManager accountTransactionManager(
            @Qualifier("accountEntityManagerFactory")EntityManagerFactory accountEntityManagerFactory
            )
    {
        return new JpaTransactionManager(accountEntityManagerFactory);
    }
}
