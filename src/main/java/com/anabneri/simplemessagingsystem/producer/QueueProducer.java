package com.anabneri.simplemessagingsystem.producer;

import com.anabneri.simplemessagingsystem.model.Messaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


@Service
public class QueueProducer {

    @Value("${spring.activemq.queue.message}")
    private String queue;

    @Autowired
    @Qualifier("jmsTemplateQueue")
    private JmsTemplate jmsTemplate;

    public void publish(Messaging messaging) {
        this.jmsTemplate.convertAndSend(queue , messaging);
        this.jmsTemplate.convertAndSend("queue.filter", messaging);
    }
}
