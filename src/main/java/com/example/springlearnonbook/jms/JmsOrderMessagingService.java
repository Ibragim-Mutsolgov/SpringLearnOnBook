package com.example.springlearnonbook.jms;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.service.OrderMessagingService;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Message;

@Service
@AllArgsConstructor
public class JmsOrderMessagingService implements OrderMessagingService {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    @Override
    public void send(Destination destination, TacoOrder tacoOrder) {
        jmsTemplate.send(
                destination,
                session -> {
                    Message message = session.createObjectMessage(tacoOrder);
                    message.setStringProperty("X_ORDER_SOURCE", "WEB");
                    return message;
                });
    }

    @Override
    public void send2(TacoOrder tacoOrder) {
        jmsTemplate.convertAndSend(destination, tacoOrder,
                message -> {
                    message.setStringProperty("X_ORDER_SOURCE", "WEB");
                    return message;
                });
    }
}
*/