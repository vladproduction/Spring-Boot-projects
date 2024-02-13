package com.vladproduction.springjmssimple.consumer;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyDurableTopicConsumerB {

    @JmsListener(destination = "HelloDurableTopic", containerFactory = "myDurableTopicFactoryB")
    public void onMessage(Message message) throws JMSException {
        System.out.println("onMessage-MyDurableTopicConsumerB");
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println(text);
        }
    }
}
