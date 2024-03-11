package com.vladproduction.sbappstarting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 11-Mar-24
 */

@RestController
public class MyHelloController {

    @GetMapping("/index")
    public String index(){
        return "MyHelloController Spring Boot!";
    }
}
