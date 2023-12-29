package com.vladproduction;

import com.vladproduction.dao.Dao;
import com.vladproduction.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class, args);

    }


}


