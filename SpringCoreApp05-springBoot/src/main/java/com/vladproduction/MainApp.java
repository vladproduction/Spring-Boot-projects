package com.vladproduction;

import com.vladproduction.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class, args);

    }

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) {
        Processor processor = context.getBean(Processor.class);
        String string = processor.process();
        System.out.println("string = " + string);
    }
}


