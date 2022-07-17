package com.example.springlearnonbook.integration;

import com.example.springlearnonbook.domain.TodoProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.splitter.FileSplitter;

import java.io.File;

@Configuration
@AllArgsConstructor
public class TodoFileIntegration {

    private TodoProperties properties;
    private TodoConverter converter;

    @Bean
    public IntegrationFlow integrationFlow(){
        return IntegrationFlows
                .from(Files
                        .inboundAdapter(new File(properties.getDirectory()))
                        .preventDuplicates(true)
                        .patternFilter(properties.getFilePattern()),
                        e -> e.poller(Pollers.fixedDelay(5000L)))
                .split(Files.splitter().markers())
                .filter(p -> !(p instanceof FileSplitter.FileMarker))
                .transform(Transformers.converter(converter))
                .handle("todoMessageHandler", "out")
                .get();
    }
}
