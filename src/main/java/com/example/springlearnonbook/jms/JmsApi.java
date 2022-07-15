package com.example.springlearnonbook.jms;
/*
import com.example.springlearnonbook.domain.TacoOrder;
import com.example.springlearnonbook.service.OrderMessagingService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;
import javax.jms.JMSException;

@Configuration
@AllArgsConstructor
public class OrderApi {

    private OrderMessagingService messagingService;
    private JmsOrderReciever jmsOrderReciever;

    @Bean
    public void tacoOrder() throws JMSException {
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setId(1L);
        messagingService.send2(tacoOrder);
        jmsOrderReciever.receiverWithoutConvert();
    }
}
*/