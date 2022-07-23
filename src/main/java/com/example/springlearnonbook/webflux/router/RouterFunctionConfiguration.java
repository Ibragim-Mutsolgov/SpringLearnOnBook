package com.example.springlearnonbook.webflux.router;

import static reactor.core.publisher.Mono.just;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web
        .reactive.function.server.RequestPredicates.GET;
import static org.springframework.web
        .reactive.function.server.RouterFunctions.route;
import static org.springframework.web
        .reactive.function.server.ServerResponse.ok;


@Configuration
public class RouterFunctionConfiguration {

    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return route(GET("/hello"),
                request -> ok().body(just("Hello World!"), String.class));
    }
}
