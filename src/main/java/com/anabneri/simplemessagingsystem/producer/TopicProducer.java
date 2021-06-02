package com.anabneri.simplemessagingsystem.producer;

import com.anabneri.simplemessagingsystem.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    @Value("${spring.activemq.topic.message}")
    private String topic;

    @Autowired
    @Qualifier("jmsTemplateTopic")
    private JmsTemplate jmsTemplateTopic;

    public void publish(Message message) {
        this.jmsTemplateTopic.convertAndSend(this.topic, message);
    }
}
