package com.example.springlearnonbook.broker.jms;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfiguration {

    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter messageConverter =
                new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");
        messageConverter.setTargetType(MessageType.TEXT);
        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("order", TacoOrder.class);
        messageConverter.setTypeIdMappings(typeIdMappings);
        return messageConverter;
    }

    @Bean
    public Destination destination(){
        return new ActiveMQQueue("tacocloud.order.queue");
    }
}
*/