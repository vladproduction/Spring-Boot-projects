package com.vladproduction.springbootcinemabookingservice.exception;

public class EventAlreadyExistException extends RuntimeException {
    public EventAlreadyExistException(String message) {
        super(message);
    }
}
