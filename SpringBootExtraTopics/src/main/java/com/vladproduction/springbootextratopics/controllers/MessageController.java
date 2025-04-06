package com.vladproduction.springbootextratopics.controllers;

import com.vladproduction.springbootextratopics.components.MessageConsumer;
import com.vladproduction.springbootextratopics.services.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    //need to start ActiveMQ on the machine .\apache-activemq-5.18.3\bin\win64 activemq.bat

    private final MessageProducer messageProducer;
    private final MessageConsumer messageConsumer;

    @Autowired
    public MessageController(MessageProducer messageProducer, MessageConsumer messageConsumer) {
        this.messageProducer = messageProducer;
        this.messageConsumer = messageConsumer;
    }

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        messageProducer.sendMessage("example.queue", message);
    }

    @GetMapping("/received")
    public List<String> listReceivedMessages() {
        return messageConsumer.getMessages(); // Retrieve the received messages
    }

    @DeleteMapping("/clear")
    public void clearMessages() {
        messageConsumer.clearMessages(); // Clear messages
    }




}
