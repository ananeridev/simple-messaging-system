package com.anabneri.simplemessagingsystem.converser;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.anabneri.simplemessagingsystem.model.Messaging
import com.google.gson.Gson;




public class MessagingConverter implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {

        System.out.println("Enter on toMessage converter");

        Messaging messaging = (Messaging) object;
        TextMessage textMessage = session.createTextMessage();
        textMessage.setBooleanProperty("visualized", messaging.isSeen());
        textMessage.setText(new Gson().toJson(messaging));

        System.out.println("left the conversation");
        return textMessage;

    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        System.out.println("Enter on conversation fromMessage");

        TextMessage textMessage = (TextMessage) message;

        String json = textMessage.getText();

        Messaging messaging = new Gson().fromJson(json,Messa.class);

        System.out.println("left the conversation");

        return messaging;
    }


}
