package com.vladproduction.aopAdvance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyInterceptor {

    @Autowired
    private MyService myService;



//    @Around("execution(* com.vladproduction.aopAdvance.MyService.*(..))")
//    public Object executionTimeJoinPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        long start = System.nanoTime();
//        Object proceed = proceedingJoinPoint.proceed();
//        long finish = System.nanoTime();
//        System.out.println("Time: " + (finish - start));
//        return proceed;
//
//    }

    @Around("execution(* com.vladproduction.aopAdvance.MyService.*(..))")
    public Object executionTimeJoinPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Aspect Start");
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        if("doAction".equals(methodName)){
            long delay = (long) methodArgs[0];
            if(delay > 10000){
                System.out.println("not valid: time is too long!");
                System.out.println("Aspect Finish (validated)");
                return null;
            }
            if(delay < 0){
                methodArgs[0] = 5000L;
                System.out.println("not valid: time is negative! set default value (5000)");
            }
        }else if ("add".equals(methodName)){
            int a = (int)methodArgs[0];
            int b = (int)methodArgs[1];
           return myService.subtract(a, b);
        }



        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed(methodArgs);
        long finish = System.nanoTime();
        System.out.println("Time: " + (finish - start));
        System.out.println("Aspect Finish");
        return proceed;

    }


}
