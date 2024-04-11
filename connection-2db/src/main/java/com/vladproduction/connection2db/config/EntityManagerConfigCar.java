package com.vladproduction.connection2db.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "carEntityManagerFactory",
        transactionManagerRef = "carTransactionManager",
        basePackages = "com.vladproduction.connection2db.repository")
public class EntityManagerConfigCar {

    @Bean(name = "carEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean carEntityManagerFactory(
            @Qualifier("carDataSource") DataSource carDataSource
    ) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(carDataSource);
        factory.setPackagesToScan("com.vladproduction.connection2db.entity.car");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("spring.jpa.hibernate.ddl-auto", "update");
        factory.setJpaProperties(properties);
        return factory;
    }

    @Bean(name = "carTransactionManager")
    public PlatformTransactionManager carTransactionManager(
            @Qualifier("carEntityManagerFactory") EntityManagerFactory carEntityManagerFactory
    )
    {
        return new JpaTransactionManager(carEntityManagerFactory);
    }

}
