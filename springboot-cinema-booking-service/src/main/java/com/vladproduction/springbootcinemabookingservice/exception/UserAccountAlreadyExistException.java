package com.vladproduction.springbootcinemabookingservice.exception;

public class UserAccountAlreadyExistException extends RuntimeException {
    public UserAccountAlreadyExistException(String message) {
        super(message);
    }
}
