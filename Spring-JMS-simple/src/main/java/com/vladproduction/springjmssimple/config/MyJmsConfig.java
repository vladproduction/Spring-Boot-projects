package com.vladproduction.springjmssimple.config;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.Queue;
import jakarta.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class MyJmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public JmsListenerContainerFactory myTopicFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    public JmsListenerContainerFactory myDurableTopicFactoryA(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        defaultJmsListenerContainerFactory.setSubscriptionDurable(true);
        defaultJmsListenerContainerFactory.setClientId("durableA");
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    public JmsListenerContainerFactory myDurableTopicFactoryB(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        defaultJmsListenerContainerFactory.setSubscriptionDurable(true);
        defaultJmsListenerContainerFactory.setClientId("durableB");
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    public Queue myQueueWithHeader() {
        return new ActiveMQQueue("HelloWithHeaderQueue");
    }

    @Bean
    public Queue helloQueue() {
        return new ActiveMQQueue("HelloQueue");
    }

    @Bean
    public Topic helloTopic() {
        return new ActiveMQTopic("HelloTopic");
    }

    @Bean
    public Topic helloDurableTopic() {
        return new ActiveMQTopic("HelloDurableTopic");
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        // Set destination name and other options
        jmsTemplate.setDefaultDestinationName("myQueue");
        return jmsTemplate;
    }


}
