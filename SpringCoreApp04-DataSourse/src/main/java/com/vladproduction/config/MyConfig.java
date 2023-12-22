package com.vladproduction.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.converter.Converter;
import com.vladproduction.converter.JsonConverter;
import com.vladproduction.converter.XmlConverter;
import com.vladproduction.dao.Dao;
import com.vladproduction.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan(basePackages = {"com.vladproduction"})
@PropertySource("classpath:config.properties")
public class MyConfig {

    @Autowired
    private Dao dao;

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public Converter jsonConverter(){
        return new JsonConverter(mapper());
    }

    @Bean
    public Converter xmlConverter(){
        return new XmlConverter();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Processor processor(){
        return new Processor(dao, xmlConverter());
//        return new Processor(dao, jsonConverter());
    }


}
