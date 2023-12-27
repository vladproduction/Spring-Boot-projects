package com.vladproduction;

import com.vladproduction.data.Student;
import com.vladproduction.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentRepository repository) {
        return (args) -> {
            //addStudents(repository);

            //repository.findAll().forEach(System.out::println);

            repository.findByFirstNameStartsWith("Ja").forEach(System.out::println);
        };
    }

    private void addStudents(StudentRepository repository) {
        repository.save(new Student("John", "Dow", 20));
        repository.save(new Student("Jane", "Bird", 21));
        repository.save(new Student("Kate", "Wing", 19));
        repository.save(new Student("Jack", "Small", 21));
    }
}
