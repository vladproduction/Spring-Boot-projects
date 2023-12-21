package com.vladproduction.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggerAspect2 {

    private Logger logger = Logger.getLogger(LoggerAspect2.class.getName());

    @Pointcut("execution(* com.vladproduction.management.*.*set*(..))")
    public void allSetters(){

    }

    @Around("allSetters()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        logger.severe("Call method: " + methodName + " ;with args: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        logger.severe("Method: " + methodName + "result = " + result);
        return result;

    }


}
