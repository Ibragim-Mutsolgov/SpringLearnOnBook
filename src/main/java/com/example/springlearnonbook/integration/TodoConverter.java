package com.example.springlearnonbook.integration;

import com.example.springlearnonbook.domain.Todo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TodoConverter implements Converter<String, Todo> {

    @Override
    public Todo convert(String source) {
        List<String> list = Stream.of(source.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return new Todo(list.get(0), Boolean.parseBoolean(list.get(1)));
    }
}
