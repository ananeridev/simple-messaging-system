package com.anabneri.simplemessagingsystem.consumer;

import com.anabneri.simplemessagingsystem.model.Messaging;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @JmsListener(destination = "queue.message", containerFactory = "jmsFactoryQueue")
    public void consumeMessageTopic(Messaging messaging) {

        System.out.println("QUEUE ----->"+ messaging.toString());
    }

    @JmsListener(destination = "queue.filter",
        containerFactory = "jmsFactoryQueue",
        selector = "visualized = false",
        subscription = "")
    public void consumeMessageTopicSelector(Messaging messaging) {
        System.out.println("QUEUE SELECTOR ----->"+ messaging);
    }

}
