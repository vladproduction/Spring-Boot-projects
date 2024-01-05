package com.vladproduction.controllers;

import com.vladproduction.model.ContextApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/context")
public class ContextAppController {

    @Value("${server.port}")
    private int port;

    @Value("${contextApp.profile.property}")
    private String profile;

    @GetMapping
    public ContextApp getContextApp(){
        return new ContextApp(port,  profile + " ContextAppController");
    }

    @GetMapping("/dev")
    public ContextApp getContextAppDev(){
        return new ContextApp(port,  profile + " - ContextAppController");
    }

    @GetMapping("/prod")
    public ContextApp getContextAppProd(){
        return new ContextApp(port,  profile + " - ContextAppController");
    }

    @GetMapping("/uat")
    public ContextApp getContextAppUat(){
        return new ContextApp(port,  profile + " - ContextAppController");
    }

}
