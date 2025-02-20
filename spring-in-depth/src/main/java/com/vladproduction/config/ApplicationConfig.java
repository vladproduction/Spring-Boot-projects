package com.vladproduction.config;

import com.vladproduction.services.GreetingService;
import com.vladproduction.services.OutputService;
import com.vladproduction.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configurable
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active'] != 'dev')}")
    private boolean is24hours;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }

    @Bean
    public TimeService timeService(){
        return new TimeService(is24hours);
    }

    /*@Bean
    @Profile("!dev") //not dev profile (so, it is prod profile)
    public TimeService timeService(){
        return new TimeService(true);
    }

    @Bean
    @Profile("dev") //dev profile
    public TimeService devTimeService12(){
        return new TimeService(false);
    }*/

    @Bean
    public OutputService outputService(){
        return new OutputService(greetingService, timeService, name);
    }

}
