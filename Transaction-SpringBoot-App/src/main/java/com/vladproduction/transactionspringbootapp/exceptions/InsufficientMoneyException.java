package com.vladproduction.transactionspringbootapp.exceptions;

/**
 * Created by vladproduction on 26-Mar-24
 */

public class InsufficientMoneyException extends RuntimeException{

    public InsufficientMoneyException(String message) {
        super(message);
    }
}
