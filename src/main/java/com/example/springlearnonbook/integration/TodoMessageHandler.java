package com.example.springlearnonbook.integration;

import com.example.springlearnonbook.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TodoMessageHandler {

    Logger logger = LoggerFactory.getLogger(TodoMessageHandler.class);

    public void out(Todo todo){
        logger.info(">>> {}", todo);
    }
}
