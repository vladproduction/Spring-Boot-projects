package com.vladproduction.aspects;


import com.vladproduction.exceptions.CountryDoesNotExistException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class CountryDoesNotExistAspect {

    private Logger logger = Logger.getLogger(CountryDoesNotExistAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.vladproduction.dao.DaoPassengerImpl.insert(..))",
    throwing = "ex")
    public void log(CountryDoesNotExistException ex){
        logger.severe("Trying to insert a passenger with an unexisting country: " + ex.getCountryCode());
    }
}
