package com.example.springlearnonbook.broker.jms;
/*
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

@Component
@AllArgsConstructor
public class JmsOrderReciever {

    private JmsTemplate jmsTemplate;
    private MessageConverter messageConverter;
    private Destination destination;

    public void receiver() throws JMSException {
        Message message = jmsTemplate.receive(destination);
        System.out.println(messageConverter.fromMessage(message));
    }

    public void receiverWithoutConvert(){
        System.out.println(
                "JMS\n" +
                jmsTemplate.receiveAndConvert(destination));
    }
}
*/