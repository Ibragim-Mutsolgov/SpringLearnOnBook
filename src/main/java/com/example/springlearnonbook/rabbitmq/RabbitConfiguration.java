package com.example.springlearnonbook.rabbitmq;
/*
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String QUEUE = "message_queu";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY = "message_routing";
    public static final String que = "tacocloud_order";

//    @Bean//1
//    public Queue queue(){
//        return new Queue(QUEUE);
//    }
//
//    @Bean//2
//    public TopicExchange topicExchange(){
//        return new TopicExchange(EXCHANGE);
//    }
//
//    @Bean//3
//    public Binding binding(Queue queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
//    }

    @Bean//4
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

//    @Bean//5
//    public AmqpTemplate amqpTemplate(ConnectionFactory c){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(c);
//        rabbitTemplate.setMessageConverter(messageConverter());
//        return rabbitTemplate;
//    }
}
*/