package com.vladproduction.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggerAspect1 {

    private Logger logger = Logger.getLogger(LoggerAspect1.class.getName());

    @Before("execution(public String com.vladproduction.management.Flight.getId())")
    public void loggingAdviceGetId(){
        logger.info("Flight getId method will be called");
    }

    @AfterReturning("execution(public * *.print())")
    public void loggingAdvicePrint(){
        logger.warning("Print method has been called");
    }

    @Pointcut("within(com.vladproduction.management.Ticket)")
    public void allTicketsMethods(){

    }

    @After("allTicketsMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        logger.info("A ticket method has been called");
        logger.info(joinPoint.toString());
        logger.info(joinPoint.getTarget().toString());
    }


}
