package com.vladproduction.controllers;

import com.vladproduction.model.ContextApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile(value = "uat")
@RestController
@RequestMapping(path = "/api/context")
public class ContextAppControllerUat {

    @Value("${server.port}")
    private int port;

    @Value("${contextApp.profile.property}")
    private String profile;

    @GetMapping("/uatController")
    public ContextApp getContextApp(){
        return new ContextApp(port,  profile+ ": uatController-ContextAppControllerUat");
    }

}
