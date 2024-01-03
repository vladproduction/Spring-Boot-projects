package com.vladproduction.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.vladproduction.demo.*.*(..))")
    public void logBeforeMethodExecution() {

        System.out.println("logBeforeMethodExecution()");
    }

    @After("execution(* com.vladproduction.demo.*.*(..))")
    public void logAfterMethodExecution() {

        System.out.println("logAfterMethodExecution()");
    }
}
