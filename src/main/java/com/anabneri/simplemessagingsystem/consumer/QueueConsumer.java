package com.anabneri.simplemessagingsystem.consumer;

import com.anabneri.simplemessagingsystem.model.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @JmsListener(destination = "queue.message", containerFactory = "jmsFactoryQueue")
    public void consumeMessageTopic(Message message) {

        System.out.println("QUEUE ----->"+ message.toString());
    }

    @JmsListener(destination = "queue.filter",
        containerFactory = "jmsFactoryQueue",
        selector = "visualized = false",
        subscription = "")
    public void consumeMessageTopicSelector(Message message) {
        System.out.println("QUEUE SELECTOR ----->"+ message);
    }

}
