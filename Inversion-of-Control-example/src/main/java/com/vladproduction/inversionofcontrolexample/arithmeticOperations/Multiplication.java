package com.vladproduction.inversionofcontrolexample.arithmeticOperations;

import org.springframework.stereotype.Component;

@Component
public class Multiplication implements ArithmeticOperation{

    @Override
    public int execute(int a, int b) {

        return a * b;
    }
}
