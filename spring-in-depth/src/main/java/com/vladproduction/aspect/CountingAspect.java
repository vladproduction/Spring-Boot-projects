package com.vladproduction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CountingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger("VLADPRODUCTION AOP COUNTING-ASPECT-APPLICATION");

    private static final Map<String, Integer> countingMap = new HashMap<>();

    @Pointcut("@annotation(Countable)")
    public void executeCounting(){

    }

    @Before("executeCounting()")
    public void incrementCountMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();

        if(countingMap.containsKey(methodName)){
            int count = countingMap.get(methodName);
            count++;
            countingMap.put(methodName, count);
        } else {
            countingMap.put(methodName, 1);
        }

        StringBuilder message = new StringBuilder("Current counts are: ");
        /*countingMap.forEach(
                (k, v) -> {
                    message.append(k + "::" + v + "|");
                });*/

        countingMap.forEach(
                (k, v) -> {
                    message.append(k).append("::").append(v).append("|");
                });

        LOGGER.info(message.toString());

    }

}
