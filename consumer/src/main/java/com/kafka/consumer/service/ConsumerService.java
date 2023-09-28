package com.kafka.consumer.service;

import com.kafka.consumer.config.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(id = "foo", topics = "FirstTopic", groupId = KafkaProperties.CONSUMER_GROUP_ID)
    public void listen(String data) {
        log.info("Received Message : {}", data);
    }
}
