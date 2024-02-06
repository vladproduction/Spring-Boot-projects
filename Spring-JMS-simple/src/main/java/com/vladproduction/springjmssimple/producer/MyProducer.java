package com.vladproduction.springjmssimple.producer;

import jakarta.jms.*;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

    private ConnectionFactory connectionFactory;
    private Destination destination;

    public MyProducer(ConnectionFactory connectionFactory, Destination destination) {
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
}
