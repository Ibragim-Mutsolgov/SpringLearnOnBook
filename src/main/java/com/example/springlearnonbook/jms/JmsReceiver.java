package com.example.springlearnonbook.jms;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderReceiver {

    private JmsTemplate jmsTemplate;

    @Bean
    public void receiver(){
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setId(2L);
        jmsTemplate.convertAndSend("tacocloud.order.queue", tacoOrder);
    }
}
*/