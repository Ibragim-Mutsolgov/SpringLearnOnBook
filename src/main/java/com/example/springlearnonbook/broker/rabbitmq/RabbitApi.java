package com.example.springlearnonbook.broker.rabbitmq;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.service.RabbitMessagingService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitApi {

    private RabbitMessagingService service;
    private RabbitOrderReciever rabbitOrderReciever;

    @Bean
    public void send(){
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setId(3L);
        service.send(tacoOrder);
        rabbitOrderReciever.receiver();
    }

    @Bean
    public void send2(){
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setId(4L);
        service.sendOrder(tacoOrder);
        rabbitOrderReciever.receiverOrder();
    }
}
*/