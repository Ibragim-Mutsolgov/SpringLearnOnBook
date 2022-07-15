package com.example.springlearnonbook.rabbitmq;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.service.RabbitMessagingService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitOrderMessagingService implements RabbitMessagingService {

    private RabbitTemplate template;
    private MessageConverter converter;

    @Override
    public void send(TacoOrder tacoOrder){
        MessageProperties properties = new MessageProperties();
        properties.setHeader("X_ORDER_SOURCE", "WEB");
        Message message = converter.toMessage(tacoOrder, properties);
        template.send(RabbitConfiguration.QUEUE, message);
    }

    @Override
    public void sendOrder(TacoOrder tacoOrder) {
        template.convertAndSend(RabbitConfiguration.EXCHANGE, RabbitConfiguration.ROUTING_KEY,  tacoOrder,
                message -> {
                    message.getMessageProperties().setHeader("X_ORDER_SOURCE", "WEB");
                    return message;
                });
    }
}
*/