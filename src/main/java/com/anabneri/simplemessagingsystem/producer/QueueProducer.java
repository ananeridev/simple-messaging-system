package com.anabneri.simplemessagingsystem.producer;

import com.anabneri.simplemessagingsystem.model.Message;
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

    public void publish(Message message) {
        this.jmsTemplate.convertAndSend(queue , message);
        this.jmsTemplate.convertAndSend("queue.filter", message);

    }
}
