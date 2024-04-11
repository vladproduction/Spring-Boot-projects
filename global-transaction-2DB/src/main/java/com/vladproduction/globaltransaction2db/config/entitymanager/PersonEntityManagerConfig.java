package com.vladproduction.globaltransaction2db.config.entitymanager;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "personEntityManagerFactory",
        transactionManagerRef = "personTransactionManager",
        basePackages = {"com.vladproduction.globaltransaction2db.repository"}
)
public class PersonEntityManagerConfig {

    @Autowired
    @Qualifier("personDataSource")
    private DataSource personDataSource;

    @Bean(name = "personEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean personEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(personDataSource);
        factory.setPackagesToScan("com.vladproduction.globaltransaction2db.entity.person");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("spring.jpa.hibernate.ddl-auto","update");
        factory.setJpaProperties(properties);
        return  factory;
    }


    @Bean(name = "personTransactionManager")
    public PlatformTransactionManager personTransactionManager(
            @Qualifier("personEntityManagerFactory") EntityManagerFactory personEntityManagerFactory
    )
    {
        return new JpaTransactionManager(personEntityManagerFactory);
    }


}
