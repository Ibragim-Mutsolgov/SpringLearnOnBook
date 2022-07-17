package com.example.springlearnonbook.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TodoProperties {

    @Value("${todo.directory}")
    private String directory;

    @Value("${todo.file-pattern}")
    private String filePattern;
}
