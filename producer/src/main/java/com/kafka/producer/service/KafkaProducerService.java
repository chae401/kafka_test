package com.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private static int runningId = 0;

    private final KafkaTemplate kafkaTemplate;

    @Scheduled(fixedRate = 1000*10, initialDelay = 5*1000)
    public void produceMessage(){
        log.info("Produce Message - Begin");
        String message = String.format("%d번째 메시지를 %s에 전송하였습니다.",
                runningId++, LocalDateTime.now().toString());
        CompletableFuture<SendResult<String, String>> completableFuture =
                kafkaTemplate.send("FirstTopic", message);

        completableFuture.whenComplete((result, ex)->{
            if( ex == null){
                // success
                log.info("SUCCESS!! This is the result: {}", result);
            }else{
                // fail
                log.info("ERROR Kafka error happened", ex);
            }
        });

        log.info("Produce Message - End {}", message);

    }
}
