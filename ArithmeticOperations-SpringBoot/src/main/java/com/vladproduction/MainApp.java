package com.vladproduction;

import com.vladproduction.execution.*;
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
    ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Sum sum = context.getBean(Sum.class);
        System.out.println("sum = " + sum.execute(10, 20));
        System.out.println("---------------------");

        Subtraction subtraction = context.getBean(Subtraction.class);
        System.out.println("subtraction = " + subtraction.execute(10, 20));
        System.out.println("---------------------");

        Multiplication multiplication = context.getBean(Multiplication.class);
        System.out.println("multiplication = " + multiplication.execute(10, 20));
        System.out.println("---------------------");

        Division division = context.getBean(Division.class);
        System.out.println("division = " + (double)division.execute(10, 20));
        System.out.println("---------------------");
    }
}
