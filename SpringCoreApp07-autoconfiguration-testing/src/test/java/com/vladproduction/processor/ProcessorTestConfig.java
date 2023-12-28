package com.vladproduction.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.converter.Converter;
import com.vladproduction.converter.JsonConverter;
import com.vladproduction.converter.XmlConverter;
import com.vladproduction.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ProcessorTestConfig {

    @Autowired
    private Dao dao;

    @Autowired
    private Converter jsonConverter;

//    @Bean
//    public ObjectMapper mapper(){return new ObjectMapper();}
//
//    @Bean
//    public Converter jsonConverter(){
//        return new JsonConverter(mapper());
//    }
//
//    @Bean
//    public Converter xmlConverter(){
//        return new XmlConverter();
//    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Processor processor(){
//        return new Processor(dao, xmlConverter());
        return new Processor(dao, jsonConverter);
    }


}
