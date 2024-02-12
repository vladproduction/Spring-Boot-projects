package com.vladproduction.springjmssimple.producer;

import jakarta.jms.*;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    private ConnectionFactory connectionFactory;
    private Destination destination;

    @Autowired
    private JmsTemplate jmsTemplate;


    public MyProducer(ConnectionFactory connectionFactory, @Qualifier("myQueueWithHeader") Destination destination) {
        this.connectionFactory = connectionFactory;
        this.destination = destination;
    }

    public void send(String text) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession();
        MessageProducer producer = session.createProducer(destination);
        TextMessage msg = new ActiveMQTextMessage();
        msg.setText(text);
        producer.send(msg);
    }

    public void sendWithHeader(String text) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession();
        MessageProducer producer = session.createProducer(destination);
        TextMessage msg = new ActiveMQTextMessage();
        msg.setStringProperty("name", "hello");
        msg.setIntProperty("age", 20);
        msg.setText(text);
        producer.send(msg);
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(message);
    }
}
