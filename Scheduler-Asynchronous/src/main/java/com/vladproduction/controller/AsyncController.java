package com.vladproduction.controller;

import com.vladproduction.asynchronous.AsynchronousComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AsyncController {
    @Autowired
    private AsynchronousComponent asynchronousComponent;

    @PostMapping( "/async")
    public void postAsync(){
        asynchronousComponent.doAsync();
    }

    @PostMapping( "/sync")
    public void postSync(){
        asynchronousComponent.doSync();
    }
}
