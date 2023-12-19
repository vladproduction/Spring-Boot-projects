package com.vladproduction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.converter.Converter;
import com.vladproduction.converter.JsonConverter;
import com.vladproduction.converter.XmlConverter;
import com.vladproduction.dao.Dao;
import com.vladproduction.dao.DaoImpl;
import com.vladproduction.processor.Processor;

public class MainApp {
    public static void main(String[] args) {

        Dao dao = new DaoImpl("jdbc:mysql://127.0.0.1:3306/spring", "root", "11111111");
        //Converter converter = new JsonConverter(new ObjectMapper());
        Converter converter = new XmlConverter();
        Processor processor = new Processor(dao, converter);
        String string = processor.process();
        System.out.println("string = " + string);

    }
}
