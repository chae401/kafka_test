package com.kafka.consumer.service;

import com.kafka.consumer.config.KafkaProperties;
import com.kafka.consumer.dto.CafeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @KafkaListener(topics = KafkaProperties.TOPIC, groupId = KafkaProperties.CONSUMER_GROUP_ID)
    public void listen(ConsumerRecord<String, CafeDTO> record){

        log.info("Received Message : {}", record.value());
        simpMessagingTemplate.convertAndSend("/topic/cafe",record.value());

    }
    // basic test
//    @KafkaListener(id = "foo", topics = "FirstTopic", groupId = KafkaProperties.CONSUMER_GROUP_ID)
//    public void listen(String data) {
//        log.info("Received Message : {}", data);
//    }
}
