package com.vladproduction.springbootextratopics.services;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String queueName, String message) {
        jmsTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent: " + message + " to queue: " + queueName);
    }
}
