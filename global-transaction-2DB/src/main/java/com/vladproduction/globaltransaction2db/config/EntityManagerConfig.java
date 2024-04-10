package com.vladproduction.globaltransaction2db.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.yaml.snakeyaml.introspector.Property;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Configuration
public class EntityManagerConfig {

    @Autowired
    private DataSource dataSourcePerson;

    @Autowired
    private DataSource dataSourceUser;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean personEntityManager(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSourcePerson);
        factory.setPackagesToScan("com.vladproduction.globaltransaction2db.entity.person");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("spring.jpa.hibernate.ddl-auto","update");
        factory.setJpaProperties(properties);
        return  factory;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSourceUser);
        factory.setPackagesToScan("com.vladproduction.globaltransaction2db.entity.user");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("spring.jpa.hibernate.ddl-auto","update");
        factory.setJpaProperties(properties);
        return  factory;
    }
}
