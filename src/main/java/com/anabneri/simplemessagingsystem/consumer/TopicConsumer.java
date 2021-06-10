package com.anabneri.simplemessagingsystem.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import com.anabneri.simplemessagingsystem.model.Message;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class TopicConsumer {

    @Value("${spring.activemq.topic.message}")
    private String topic;

    @Autowired
    @Qualifier("jmsTemplateTopic")
    private JmsTemplate jmsTemplate;

    public void consumeTopicMessageAsynchronous() throws JMSException {
        TextMessage message = (TextMessage) jmsTemplate.receive("asynchronous.topic");
        System.out.println("TOPIC message Asynchronous ------->"+ message.getText());
    }

    @JmsListener(destination = "topic.message",
        containerFactory = "jmsFactoryTopic",
        selector = "visualized = false",
        subscription = "consumer1")
    public void consumingMessageTopicWithSelector(Message message) {
        System.out.println("SELECTOR TOPIC ------->"+ message.toString());
    }

    @JmsListener(destination = "topic.message",
        containerFactory = "jmsFactoryTopic",
        subscription = "consumer2")
    @SendTo("${spring.activemq.topic.transformacao}")
    public Message consumingMessageTopicAndSendToAnother(Message message) {
        System.out.println("REDIRECT TOPIC"+ message.toString());

        return message;
    }

    @JmsListener(destination = "topic.transformation",
        containerFactory = "jmsFactoryTopic",
        subscription = "consumer1")
    public void consumingMessageTopicTransformation(Message message) {
        System.out.println("TOPIC transformation"+ message.toString());
    }
}
