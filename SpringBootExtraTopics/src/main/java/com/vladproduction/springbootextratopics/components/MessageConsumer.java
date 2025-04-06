package com.vladproduction.springbootextratopics.components;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageConsumer {

    private static final List<String> messages = new ArrayList<>();

    @JmsListener(destination = "example.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        messages.add(message); // Store the received message
    }

    public List<String> getMessages() {
        return messages; // Provide access to the stored messages
    }

    public void clearMessages() {
        messages.clear(); // Clear all stored messages
    }

}
