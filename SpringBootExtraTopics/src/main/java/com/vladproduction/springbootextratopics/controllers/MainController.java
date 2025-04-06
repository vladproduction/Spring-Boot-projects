package com.vladproduction.springbootextratopics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //http://localhost:8080/
    @GetMapping("/")
    public String index() {
        return "index"; // This will return index.html from the templates folder
    }

    @GetMapping("/messaging")
    public String messaging() {
        return "messaging"; // This will refer to messaging.html
    }

    @GetMapping("/messaging-theory")
    public String messagingTheory() {
        return "messaging-theory"; // This will refer to messaging-theory.html
    }

    @GetMapping("/message-consumers")
    public String messageConsumers() {
        return "message-consumers"; // This will refer to message-consumers.html
    }

    @GetMapping("/message-producers")
    public String messageProducers() {
        return "message-producers"; // This will refer to message-producers.html
    }

    @GetMapping("/rest-repositories")
    public String restRepositories() {
        return "rest-repositories"; // This will refer to rest-repositories.html
    }

    @GetMapping("/actuator-theory")
    public String actuatorTheory() {
        return "actuator-theory"; // This will refer to actuator-theory.html
    }

    @GetMapping("/extending-actuator")
    public String extendingActuator() {
        return "extending-actuator"; // This will refer to extending-actuator.html
    }

    @GetMapping("/actuator-extension")
    public String actuatorExtension() {
        return "actuator-extension"; // This will refer to actuator-extension.html
    }

    @GetMapping("/boot-starters")
    public String bootStarters() {
        return "boot-starters"; // This will refer to boot-starters.html
    }

    @GetMapping("/starters")
    public String getStarters() {
        return "starters"; // This will refer to starters.html
    }

}
