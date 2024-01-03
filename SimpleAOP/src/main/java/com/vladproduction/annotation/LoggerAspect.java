package com.vladproduction.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggerAspect.class.getName());

    @Around("@annotation(com.vladproduction.annotation.LogAnnotation)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("log - start");
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        LOGGER.info("Call method: " + methodName + " ;method args: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("Method: " + methodName + "; result = " + result);
        System.out.println("log - finish");
        return result;
    }

}
