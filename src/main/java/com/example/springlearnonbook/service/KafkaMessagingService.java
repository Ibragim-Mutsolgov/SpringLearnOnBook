package com.example.springlearnonbook.service;

import com.example.springlearnonbook.domain.TacoOrder;

public interface KafkaMessagingService {

    void sendOrder();
}
