package com.vladproduction.springjmssimple.consumer;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyQueueWithHeaderConsumer1 {

    @JmsListener(destination = "HelloWithHeaderQueue", selector = "name = 'Test'")
    public void onMessage(Message message) throws JMSException {
        System.out.println("onMessage-MyQueueWithHeaderConsumer1");
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println(text);
            String name = message.getStringProperty("name");
            System.out.println("name = " + name);
            int age = message.getIntProperty("age");
            System.out.println("age = " + age);
        }
    }
}
