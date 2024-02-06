package com.vladproduction.inversionofcontrolexample.scopesExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopesConfig {

    @Bean
//    @Scope("prototype")
    public MyPrototype myPrototype(){
        return new MyPrototype("default type");
    }

    @Bean
    public MySingleton mySingleton(ApplicationContext applicationContext){
        return new MySingleton("default name", myPrototype(), applicationContext);
    }

    @Bean
    public MySingleton mySingletonExtra(ApplicationContext applicationContext){
        return new MySingleton("default name", myPrototype(), applicationContext);
    }

//    @Bean
//    public MySingleton mySingleton(MyPrototype myPrototype){
//        return new MySingleton("default name", myPrototype);
//    }



}
