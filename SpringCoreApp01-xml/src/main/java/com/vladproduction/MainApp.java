package com.vladproduction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.converter.Converter;
import com.vladproduction.converter.JsonConverter;
import com.vladproduction.converter.XmlConverter;
import com.vladproduction.dao.Dao;
import com.vladproduction.dao.DaoImpl;
import com.vladproduction.processor.Processor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

//        Dao dao = new DaoImpl("jdbc:mysql://127.0.0.1:3306/spring", "root", "11111111");
//        //Converter converter = new JsonConverter(new ObjectMapper());
//        Converter converter = new XmlConverter();
//        Processor processorA = new Processor(dao, converter);
//        String stringA = processorA.process();
//        System.out.println("stringA = " + stringA);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Processor processor = applicationContext.getBean("processor", Processor.class);
        String string = processor.process();
        System.out.println("string = " + string);
        Processor processor2 = applicationContext.getBean("processor", Processor.class);
        System.out.println("=====================");
        int hashCode = processor.hashCode();
        int hashCode2 = processor2.hashCode();
        System.out.println(hashCode);
        System.out.println(hashCode2);
        System.out.println(processor.equals(processor2));
        System.out.println(processor == processor2);

//        applicationContext.close();

    }
}
