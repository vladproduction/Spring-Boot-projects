package com.vladproduction.example5_exceptions;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Aspect
@Service
public class ExceptionAspect {

    private final Logger logger = Logger.getLogger(ExceptionAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "runtimeException")
    public void processException(RuntimeException runtimeException) throws Throwable{
        logger.severe(runtimeException.getMessage());
    }
}
