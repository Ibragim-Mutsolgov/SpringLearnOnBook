package com.example.springlearnonbook.integration;

import com.example.springlearnonbook.domain.Todo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TodoConfiguration implements CommandLineRunner {

    private MessageChannel input;
    private MessageChannel output;

    @Override
    public void run(String... args) throws Exception {
        input.send(
                MessageBuilder
                        .withPayload(new Todo("buy milk today", true))
                        .build()
        );
//        output.send(
//                MessageBuilder
//                        .withPayload(new Todo("BUY", false))
//                        .build()
//        );
    }
}
