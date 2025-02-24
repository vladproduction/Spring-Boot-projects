package com.vladproduction.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ Aspect: Declares the class as an Aspect.
 * @ Before: Specifies that the logBeforeMethod advice should run before the execution of any method in the specified package.
 * @ After: Specifies that the logAfterMethod advice should run after the execution of any method in the specified package.
 * This demonstrates how one Aspect can encapsulate the cross-cutting concerns of logging before and after method executions in a given package.
 * */

@Component
@Aspect
public class LoggingAspectDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectDemo.class);

    @Before("execution(* com.vladproduction.services.*.*(..))")
    public void logBeforeMethod(){
        LOGGER.info("Method begin");
    }

    @After("execution(* com.vladproduction.services.*.*(..))")
    public void logAfterMethod(){
        LOGGER.info("Method end");
    }

}
