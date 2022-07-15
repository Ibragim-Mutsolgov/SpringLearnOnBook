package com.example.springlearnonbook.rabbitmq;
/*
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitOrderReciever {

    private RabbitTemplate template;
    private MessageConverter converter;

    public void receiver(){
        Message message = template.receive(RabbitConfiguration.QUEUE);

        if(message != null){
            System.out.println(
                    "RABBIT\n" +
                            converter.fromMessage(message));
        }
    }

    public void receiverOrder(){
        System.out.println(
                "RABBIT\n" +
                template.receiveAndConvert(RabbitConfiguration.QUEUE));
    }
}
*/