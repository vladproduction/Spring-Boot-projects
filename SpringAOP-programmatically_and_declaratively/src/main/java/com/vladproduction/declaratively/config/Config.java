package com.vladproduction.declaratively.config;

import com.vladproduction.declaratively.aspects.FlightAspect;
import com.vladproduction.declaratively.management.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public FlightAspect aspect(){
        return new FlightAspect();
    }

    @Bean
    public Flight flight(){
        Flight flight = new Flight();
        flight.setId("AA1234");
        flight.setCompany("ABC Flights");
        return flight;
    }
}
