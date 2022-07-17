package com.example.springlearnonbook.integration;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@Configuration
@AllArgsConstructor
public class FileIntegrationSend {

    @Bean
    public ApplicationRunner run(MessageChannel fileinput) throws Exception {
        return args -> {
            fileinput.send(
                    MessageBuilder.withPayload("welcome")
                            .build()
            );
            fileinput.send(
                    MessageBuilder
                            .withPayload("BYE").build()
            );
        };
    }
}
