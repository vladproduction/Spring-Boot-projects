package com.vladproduction.controllers;

import com.vladproduction.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

//    @Autowired or through constructor we can IoC
    private final PropertyService propertyServiceOne;
    private final PropertyService propertyServiceTwo;

    public PropertyController(@Qualifier("FirstService") PropertyService propertyServiceOne,
                              @Qualifier("SecondService")PropertyService propertyServiceTwo) {
        this.propertyServiceOne = propertyServiceOne;
        this.propertyServiceTwo = propertyServiceTwo;
    }

    @GetMapping(path = "api/property1")
    public ResponseEntity<String> getProperty1(){
        return ResponseEntity.ok(propertyServiceOne.getPropertyValue());
    }

    @GetMapping(path = "api/property2")
    public ResponseEntity<String> getProperty2(){
        return ResponseEntity.ok(propertyServiceTwo.getPropertyValue());
    }
}
