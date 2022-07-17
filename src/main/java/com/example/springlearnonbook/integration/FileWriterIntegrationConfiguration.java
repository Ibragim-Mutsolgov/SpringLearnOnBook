package com.example.springlearnonbook.integration;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

@Configuration
public class FileWriterIntegrationConfiguration {

    @Bean
    public MessageChannel textInChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel eventChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel oddChannel(){
        return new DirectChannel();
    }

    @Bean
    @Router(inputChannel = "numberChannel")
    public AbstractMessageRouter router(){
        return new AbstractMessageRouter() {
            @Override
            protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
                Integer number = (Integer) message.getPayload();
                if(number % 2 == 0){
                    return Collections.singleton(eventChannel());
                }
                return Collections.singleton(oddChannel());
            }
        };
    }

    @Bean
    @Transformer(inputChannel = "textInChannel",
    outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> transformer(){
        return String::toUpperCase;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler handler(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("/tmp/sia6/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

//    @Bean
//    public IntegrationFlow integrationFlow(){
//        return IntegrationFlows
//                .from(MessageChannels.direct("textInChannel"))
//                .<String, String> transform(String::toUpperCase)
//                .handle(Files
//                        .outboundAdapter(new File("/tmp/sia6/files"))
//                        .fileExistsMode(FileExistsMode.APPEND)
//                        .appendNewLine(true)
//                ).get();
//    }
}
*/