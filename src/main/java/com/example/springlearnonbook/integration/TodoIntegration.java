package com.example.springlearnonbook.integration;

import com.example.springlearnonbook.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class TodoIntegration {

    @Bean
    public MessageChannel input(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel output(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel toTransform(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel toLog(){
        return new DirectChannel();
    }

    @MessageEndpoint
    static class SimpleFilter{
        @Filter(inputChannel = "input", outputChannel = "toTransform")
        public boolean simple(Todo message){
            return message.isCompleted();
        }
    }

    @MessageEndpoint
    static class SimpleFilter2{
        @Transformer(inputChannel = "toTransform", outputChannel = "toLog")
        public String simple2(Todo message){
            return message.getDescription().toUpperCase();
        }
    }

    @Bean
    @ServiceActivator(inputChannel = "toLog")
    public LoggingHandler loggingHandler(){
        LoggingHandler handler = new LoggingHandler(LoggingHandler.Level.INFO);
        handler.setLoggerName("SIMPLE_LOGGER");
        handler.setLogExpressionString("headers.id + ': ' + payload");
        return handler;
    }

//    @MessageEndpoint
//    static class Simple3{
//        Logger logger = LoggerFactory.getLogger(Simple3.class);
//
//        @ServiceActivator(inputChannel = "toLog")
//        public void process(String message){
//            logger.info(message);
//        }
//    }

//    @Bean
//    public IntegrationFlow integrationFlow(){
//        return IntegrationFlows
//                .from(input())
//                .filter(Todo.class, Todo::isCompleted)
//                .transform(Todo.class, t -> t.getDescription().toUpperCase())
//                .handle(System.out::println)
//                .get();
//    }
//
//    @Bean
//    public IntegrationFlow integrationOut(){
//        return IntegrationFlows
//                .from(output())
//                .filter(Todo.class, t -> !t.isCompleted())
//                .transform(Todo.class, t -> t.getDescription().toLowerCase())
//                .handle(System.out::println)
//                .get();
//    }
}