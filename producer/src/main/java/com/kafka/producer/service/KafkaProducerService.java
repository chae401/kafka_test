package com.kafka.producer.service;

import com.kafka.producer.dto.CafeDTO;

public interface KafkaProducerService {
    String sendMsg(CafeDTO cafeDTO);
}
