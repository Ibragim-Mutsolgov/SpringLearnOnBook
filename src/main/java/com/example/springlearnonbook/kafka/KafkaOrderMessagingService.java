package com.example.springlearnonbook.kafka;

import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.service.KafkaMessagingService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaOrderMessagingService implements KafkaMessagingService {

    private KafkaTemplate<String, TacoOrder> kafkaTemplate;

    @Override
    public void sendOrder() {
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setId(5L);
        kafkaTemplate.send(KafkaConfiguration.TOPIC, tacoOrder);
    }
}
