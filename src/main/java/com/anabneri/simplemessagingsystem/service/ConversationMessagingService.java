package com.anabneri.simplemessagingsystem.service;

import com.anabneri.simplemessagingsystem.model.Message;
import com.anabneri.simplemessagingsystem.model.Status;
import com.anabneri.simplemessagingsystem.producer.QueueProducer;
import com.anabneri.simplemessagingsystem.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationMessagingService {

    @Autowired
    QueueProducer queueProducer;

    @Autowired
    TopicProducer topicProducer;

    public Status queueMessagingInclude(Message message) {

        try {
            queueProducer.publish(message);
        } catch (Exception e) {
            return new Status("ERROR","Message not processed");
        }

        return new Status("Waiting client confirmation", "You message order was solicited to provider");
    }

    public Status topicMessageInclude(Message message) {

        try {
            topicProducer.publish(message);
        } catch (Exception e) {
            return new Status("ERROR", "Message not processed");
        }
        return new Status("Waiting client confirmation", "You message order was solicited to provider")
    }
}
