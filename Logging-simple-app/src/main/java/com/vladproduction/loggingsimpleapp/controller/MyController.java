package com.vladproduction.loggingsimpleapp.controller;

import com.vladproduction.loggingsimpleapp.model.Item;
import com.vladproduction.loggingsimpleapp.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 12-Mar-24
 */

@RestController
public class MyController {

    Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculator-loggin")
    public int getData(@RequestBody Item item){
        log.trace("===trace msg".toUpperCase());
        log.debug("===debug msg".toUpperCase());
        log.info("===info msg".toUpperCase());
        log.warn("===warn msg".toUpperCase());
        log.error("===error msg".toUpperCase());

        int result = calculatorService.calculate(item);
        log.info("result = " + result);

        return result;
    }

}
