package com.vladproduction.aopAdvance;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void doAction(long delay){
        System.out.println("doAction() - START; delay = " + delay);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doAction() - FINISH");
    }

    public Integer add(int a, int b){
        System.out.println("add() a = " + a + " + b = " + b);
        return a + b;
    }

    public Integer subtract(int a, int b){
        System.out.println("subtract() a = " + a + " - b = " + b);
        return a - b;
    }
}
