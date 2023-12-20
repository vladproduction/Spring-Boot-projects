package com.vladproduction.example2_AspectJ;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

@Aspect
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Before("execution(* *.*Passenger(..))")
    public void before(){
        logger.info("logger START");
    }

    @After("execution(* *.*Passenger(..))")
    public void after(){
        logger.info("logger FINISH");
    }
}
