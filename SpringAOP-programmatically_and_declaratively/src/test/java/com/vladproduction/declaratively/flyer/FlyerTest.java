package com.vladproduction.declaratively.flyer;

import com.vladproduction.declaratively.management.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = com.vladproduction.declaratively.config.Config.class)
class FlyerTest {

    @Autowired
    private Flight flight;

    @Test
    public void flyerTest(){
        assertTrue(flight instanceof Flight);
        System.out.println(flight.getId());
        System.out.println(flight.getCompany());

        assertTrue(flight instanceof Flyer);
        ((Flyer)flight).takeOff();
        ((Flyer)flight).fly();
        ((Flyer)flight).land();

        System.out.println(flight.getClass().getName());
        System.out.println(flight.getClass().getSimpleName());
    }

}