package com.anabneri.simplemessagingsystem;

import com.anabneri.simplemessagingsystem.converser.MessagingConverter;
import com.anabneri.simplemessagingsystem.handler.ErrorHandlerDefault;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class config {


    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
            new ActiveMQConnectionFactory(brokerUrl);
        activeMQConnectionFactory.setTrustAllPackages(true);

        return activeMQConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsFactoryTopic() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setErrorHandler(new ErrorHandlerDefault());
        factory.setMessageConverter(getConversor());
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsFactoryQueue() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setErrorHandler(new ErrorHandlerDefault());
        factory.setMessageConverter(getConversor());
        factory.setPubSubDomain(false);
        return factory;
    }

    @Bean("jmsTemplateTopic")
    public JmsTemplate jmsTemplateTopic() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setMessageConverter(getConversor());
        return jmsTemplate;
    }

    @Bean("jmsTemplateQueue")
    public JmsTemplate jmsTemplateQueue() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setPubSubDomain(false);
        jmsTemplate.setMessageConverter(getConversor());
        return jmsTemplate;
    }

    @Bean
    public MessagingConverter getConversor() {
        return new MessagingConverter();
    }

}
