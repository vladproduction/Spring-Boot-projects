package com.vladproduction.example4_normal_execution;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggerAspect {

    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Around("@annotation(com.vladproduction.example4_normal_execution.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        logger.info("Call method: " + methodName + " ;method args: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        logger.info("Method: " + methodName + "result = " + result);
        return result;
    }
}
