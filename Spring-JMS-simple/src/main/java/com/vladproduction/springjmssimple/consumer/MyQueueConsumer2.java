package com.vladproduction.springjmssimple.consumer;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyQueueConsumer2 {

    @JmsListener(destination = "HelloQueue")
    public void onMessage(Message message) throws JMSException {
        System.out.println("onMessage-consumer2");
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println(text);
        }
    }
}
