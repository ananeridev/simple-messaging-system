package com.anabneri.simplemessagingsystem.converser;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.anabneri.simplemessagingsystem.model.Message
import com.google.gson.Gson;




public class MessagingConverter implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {

        System.out.println("Enter on toMessage converter");

        com.anabneri.simplemessagingsystem.model.Message message = (com.anabneri.simplemessagingsystem.model.Message) object;
        TextMessage textMessage = session.createTextMessage();
        textMessage.setBooleanProperty("visualized", message.isSeen());
        textMessage.setText(new Gson().toJson(message));

        System.out.println("left the conversation");
        return message;

    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        System.out.println("Enter on conversation fromMessage");

        TextMessage textMessage = (TextMessage) message;

        String json = textMessage.getText();

        com.anabneri.simplemessagingsystem.model.Message message1 = new Gson().fromJson(json,Messa.class);

        System.out.println("left the conversation");

        return message1;
    }


}
