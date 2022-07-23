package com.example.springlearnonbook.projectreactor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Configuration
@AllArgsConstructor
public class Reactor {


    @Bean
    public void justFlux(){
        Flux<String> fluxString = Flux
                .just("Hello");
        fluxString.subscribe(n -> {
            log.info(">>> Reactor: justFlux - " + n);
        });
    }

    @Bean
    public void fromFlux(){

        String[] massive = new String[]{ "H", "E", "L", "L", "o" };
        List<String> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            list.add(massive[i]);
        }

        Flux<String> fluxString = Flux.fromArray(massive);
        fluxString.subscribe(n -> { log.info(">>> Reactor: fromFlux - " + n); });

        fluxString = Flux.fromIterable(list);
        fluxString.subscribe(n -> { log.info(">>> Reactor: fromFlux - " + n); });
    }

    @Bean
    public void rangeFlux(){
        Flux<Integer> integerFlux = Flux.range(0, 5);
        integerFlux.subscribe(n -> log.info(">>> Reactor: rangeFlux - " + n));

        Flux<Long> longFlux = Flux.interval(Duration.ofSeconds(1)).take(5);
        longFlux.subscribe(n -> log.info(">>> Reactor: rangeFlux - " + n));
    }

    @Bean
    public void mergeFlux(){
        Flux<Integer> i1 = Flux.just(0, 1);
        Flux<Integer> i2 = Flux.just(2, 3);

        Flux<Integer> i3 = i1.mergeWith(i2);
        i3.subscribe(n -> log.info(">>> Reactor: mergeFlux - " + n));

        i3 = Flux.zip(i1, i2, Integer::sum);
        i3.subscribe(n -> log.info(">>> Reactor: mergerFlux - " + n));
    }

    @Bean
    public void firstFlux(){
        Flux<String> s1 = Flux.just("Hello");
        Flux<String> s2 = Flux.just("Bye");

        Flux<String> result = Flux.firstWithSignal(s1, s2);
        result.subscribe(n -> log.info(">>> Reactor: firstFlux - " + n));
    }

    @Bean
    public void skipFlux(){
        Flux<Integer> skipFlux = Flux.just(0, 1, 5, 7).skip(2);
        skipFlux.subscribe(n -> log.info(">>> Reactor: skipFlux - " + n));
    }

    @Bean
    public void filterFlux(){
        Flux<Integer> filterFlux = Flux.just(0, 1, 2, 5, 6, 8, 7).filter(n -> n % 2 == 0);
        filterFlux.subscribe(n -> log.info(">>> Reactor: filterFlux - " + n));
    }

    @Bean
    public void distinctFlux(){
        Flux<Integer> distinctFlux = Flux.just(0, 0, 1, 1, 2).distinct();
        distinctFlux.subscribe(n -> log.info(">>> Reactor: distinctFlux - " + n));
    }

    @Bean
    public void mapFlux(){
        Flux<String> mapFlux = Flux.just("cat", "dog")
                .map(String::toUpperCase);
        mapFlux.subscribe(n -> log.info(">>> Reactor: mapFlux - " + n));
    }

    @Bean
    public void bufferFlux(){
        Flux<Integer> buffer = Flux.just(0, 1, 2, 3, 4);
        buffer.buffer(3)
                .subscribe(n -> log.info(">>> Reactor: bufferFlux - " + n));
    }

    @Bean
    public void bufferAndFlatMap() {
        Flux.just("apple", "orange", "banana", "kiwi", "cherry")
                .buffer(3)
                .flatMap(n -> Flux.fromIterable(n)
                        .map(String::toUpperCase)
                        .subscribeOn(Schedulers.parallel())
                        .log()).subscribe();
    }

    @Bean
    public void allFlux(){
        Flux<String> allFlux = Flux.just("aardvark", "elephant", "koala");
        Mono<Boolean> result = allFlux.all(n -> n.contains("a"));
        result.subscribe(n -> log.info(">>> Reactor: allFlux - " + n));
    }

    @Bean
    public void anyFlux(){
        Flux<Integer> anyFlux = Flux.just(0, 0, 1, 2, 2);
        Mono<Boolean> result = anyFlux.any(n -> n == 1);
        result.subscribe(n -> log.info(">>> Reactor: anyFlux - " + n));
    }
}
