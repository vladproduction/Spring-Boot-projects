package com.vladproduction.springdataoverview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //http://localhost:8080/
    @GetMapping("/")
    public String index() {
        return "index"; // This maps to src/main/resources/templates/index.html
    }

    //http://localhost:8080/repository-pattern
    @GetMapping("/repository-pattern")
    public String repositoryPattern() {
        return "repository-pattern"; // This maps to templates/repository-pattern.html
    }

    //http://localhost:8080/spring-data-introduction
    @GetMapping("/spring-data-introduction")
    public String springDataIntroduction() {
        return "spring-data-introduction"; // This maps to templates/spring-data-introduction.html
    }

    //http://localhost:8080/embedded-databases
    @GetMapping("/embedded-databases")
    public String embeddedDatabases() {
        return "embedded-databases"; // This maps to templates/embedded-databases.html
    }

    //http://localhost:8080/spring-data-repository
    @GetMapping("/spring-data-repository")
    public String springDataRepository() {
        return "spring-data-repository"; // This maps to templates/spring-data-repository.html
    }

    //http://localhost:8080/external-databases
    @GetMapping("/external-databases")
    public String externalDatabases() {
        return "external-databases"; // This maps to templates/external-databases.html
    }

}
