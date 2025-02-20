package com.vladproduction.services;

public class GreetingService {

    private final String text;

    public GreetingService(String text) {
        this.text = text;
    }

    public String getGreeting() {
        return text;
    }
}
