package com.example.springlearnonbook.service;

import com.example.springlearnonbook.domain.TacoOrder;

public interface RabbitMessagingService {

    void send(TacoOrder tacoOrder);
    void sendOrder(TacoOrder tacoOrder);
}
