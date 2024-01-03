package com.vladproduction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class SimpleAOPComponent {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleAOPComponent.class);

    //possible to inject some services to Aspect class for pointCutting;
    private final JPAService jpaService;

    public SimpleAOPComponent(JPAService jpaService) {
        this.jpaService = jpaService;
    }

    //to use AOP principle have to create pointCut to our Service
    @Pointcut(value = "execution(* *.sendMessage(..))")
    public void sendMessagePointCut(){

    }

    //here we create joinPoints for PointCut
    //@Around cover our method before-during-after
    @Around(value = "sendMessagePointCut() && args(message)")
    public Object executionTimeJoinPoint1StringMessage(ProceedingJoinPoint proceedingJoinPoint, String message) throws Throwable {

        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        LOGGER.info(String.format("ExecutionTime: %s; message: %s", TimeUnit.NANOSECONDS.toMillis(finish-start), message));
        return proceed;

    }

    @Around(value = "sendMessagePointCut() && args(message, param)")
    public Object executionTimeJoinPoint2Integer(ProceedingJoinPoint proceedingJoinPoint,
                                          String message, Integer param) throws Throwable {

        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        LOGGER.info(String.format("ExecutionTime: %s; message: %s; param: %s", TimeUnit.NANOSECONDS.toMillis(finish-start),
                message, param));
        return proceed;

    }

    @Around(value = "sendMessagePointCut() && args(message, param)")
    public Object executionTimeJoinPoint3Boolean(ProceedingJoinPoint proceedingJoinPoint,
                                          String message, Boolean param) throws Throwable {

        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        LOGGER.info(String.format("ExecutionTime: %s; message: %s; param: %s", TimeUnit.NANOSECONDS.toMillis(finish-start),
                message, param));
        return proceed;

    }

    @Before(value = "sendMessagePointCut() && args(message)")
    public void before(String message){
        LOGGER.info("Before execution");
    }

    @After(value = "sendMessagePointCut() && args(message)")
    public void after(String message){
        LOGGER.info("After execution");
        jpaService.save();
    }

    @AfterThrowing(value = "sendMessagePointCut() && args(message)", throwing = "ex")
    public void afterThrowing(String message, Exception ex){
        LOGGER.info("AfterThrowing exception:  " + ex.getMessage());
    }
}
