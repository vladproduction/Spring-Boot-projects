package com.vladproduction.example3_Around_and_AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* *.*Passenger(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        logger.info("Call method: " + methodName + " ;with args: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        logger.info("Method: " + methodName + " ;result = "+ result);
        return result;
    }
}
