package com.vladproduction.sbappstarting;

import com.vladproduction.sbappstarting.models.Customer;
import com.vladproduction.sbappstarting.repositiries.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SbAppStartingApplication {

    private static final Logger log = LoggerFactory.getLogger(SbAppStartingApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SbAppStartingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Beans provided by Spring Boot: ");
            String[] ctxBeanDefinitionNames = ctx.getBeanDefinitionNames();
            Arrays.sort(ctxBeanDefinitionNames);
            for (String ctxBeanDefinitionName : ctxBeanDefinitionNames) {
                System.out.println(ctxBeanDefinitionName);
            }
        };
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return args -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Kessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");

        };

    }

}
