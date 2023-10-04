package com.kafka.producer.controller;

import com.kafka.producer.dto.CafeDTO;
import com.kafka.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/cafe-check")
public class ProducerController {
    private final KafkaProducerService producerService;

    @PostMapping("/num")
    public ResponseEntity<String> sendMsg(@RequestBody CafeDTO cafeDTO){
        String status = producerService.sendMsg(cafeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

}
