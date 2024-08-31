package com.vladproductions.playersdocapiswagger.exception;

public class ClubDoesNotExistException extends RuntimeException {

    private String message;
    public ClubDoesNotExistException(String message) {
        this.message = message;
    }
}
