package com.vladproduction;

import com.vladproduction.processor.Processor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        Processor processor = applicationContext.getBean(Processor.class);
        String string = processor.process();
        System.out.println("string = " + string);

        applicationContext.close();

    }
}


