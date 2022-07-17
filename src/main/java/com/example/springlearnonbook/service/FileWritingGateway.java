package com.example.springlearnonbook.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWritingGateway {

    void fileWriter(
            @Header(FileHeaders.FILENAME) String filename,
            String data
    );
}
