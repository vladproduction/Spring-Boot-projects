package com.vladproductions.playersdocapiswagger.exception;

public class PlayerNotExistException extends RuntimeException {

    private String message;
    public PlayerNotExistException(String message) {
        this.message = message;
    }
}
