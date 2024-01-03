package com.vladproduction.exceptionAspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Aspect
@Service
public class ExceptionsAspect {

    private final Logger LOGGER = Logger.getLogger(ExceptionsAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.vladproduction.exceptionAspect.BankService.*(..))", throwing = "runtimeException")
    public void processException(RuntimeException runtimeException) throws Throwable{
        LOGGER.severe(runtimeException.getMessage());
    }


}
