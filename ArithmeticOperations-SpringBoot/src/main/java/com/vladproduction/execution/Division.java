package com.vladproduction.execution;

import org.springframework.stereotype.Component;

@Component
public class Division implements ArithmeticOperation{

    @Override
    public int execute(int a, int b) {

        return  a / b;
    }
}
