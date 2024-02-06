package com.vladproduction.inversionofcontrolexample.config;

import com.vladproduction.inversionofcontrolexample.exampleHello.Hello;
import com.vladproduction.inversionofcontrolexample.exampleHello.HelloImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class MyConfigHello {

    @Value("${hello.str}")
    private String str;

    @Bean
    public Hello hello(){
        return new HelloImpl(str);
    }

    @Bean
    @Scope("prototype")
    public Hello hello2(){
        return new HelloImpl(str + "hello2()");
    }
}
