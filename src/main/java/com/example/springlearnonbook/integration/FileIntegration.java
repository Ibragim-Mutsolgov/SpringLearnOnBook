package com.example.springlearnonbook.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
@EnableIntegration
public class FileIntegration {

    @Bean
    public MessageChannel fileinput(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "fileinput")
    public GenericTransformer<String, String> transformer(){
        return String::toUpperCase;
    }

    @Bean
    public IntegrationFlow ff(){
        return IntegrationFlows
                .from("fileinput")
                .transform(transformer())
                .handle(Files
                        .outboundAdapter(new File("C:\\Users\\grinn\\IdeaProjects\\SpringLearnOnBook\\todo"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .appendNewLine(true)
                ).get();
    }
}
