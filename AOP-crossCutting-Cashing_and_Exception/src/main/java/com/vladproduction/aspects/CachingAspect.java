package com.vladproduction.aspects;

import com.vladproduction.dao.DaoPassengerImpl;
import com.vladproduction.management.Passenger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class CachingAspect {

    @Around("execution(* com.vladproduction.dao.DaoPassengerImpl.getPassenger(..))")
    public void cashPassenger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        Passenger result = (Passenger) proceedingJoinPoint.proceed();

        int id = (Integer) methodArgs[0];
        //cashing mechanism
        if(!DaoPassengerImpl.getPassengersMap().containsKey(id)){
            DaoPassengerImpl.getPassengersMap().put(id, result);
        }

    }
}
