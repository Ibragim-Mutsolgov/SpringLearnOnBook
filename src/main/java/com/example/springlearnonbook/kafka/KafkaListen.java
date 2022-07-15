package com.example.springlearnonbook.kafka;

import com.example.springlearnonbook.domain.TacoOrder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListen {

    @KafkaListener(topics = KafkaConfiguration.TOPIC)
    public void listener(TacoOrder tacoOrder){
        System.out.println(
                "KAFKA\n" +
                tacoOrder);
    }
}
