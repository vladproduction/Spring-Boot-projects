package com.vladproduction.jmeterexample.controller;

import com.vladproduction.jmeterexample.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 14-Mar-24
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    @GetMapping
    public Car getCar(){

        logger.info("Get is started");
        Car car = new Car();
        car.setId(1);
        car.setModel("model1");
        car.setAvailable(true);
        car.setPrice(50000.00);
        logger.info("Get is finished");
        logger.debug("===DEBUG=== " + car);

        return car;

    }

}
