package com.kafka.producer.service;

import com.kafka.producer.dto.CafeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService{
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public String sendMsg(CafeDTO cafeDTO) {
        CompletableFuture<SendResult<String, Object>> completableFuture =
                kafkaTemplate.send("CafeTopic", cafeDTO);
        completableFuture.whenComplete((result, ex) -> { // SendResult<Integer, Object> result, Throwable ex
            if(ex == null){
                // success
                log.info("Send a msg about cafe[{}]", cafeDTO.getId());
            }else{
                // fail
                log.error("Error occured");
            }
        });
        return "SUCCESS";
    }

    // basic test

    //private static int runningId = 0;

//    @Scheduled(fixedRate = 1000*10, initialDelay = 5*1000)
//    public void produceMessage(){
//        log.info("Produce Message - Begin");
//        String message = String.format("%d번째 메시지를 %s에 전송하였습니다.",
//                runningId++, LocalDateTime.now().toString());
//        CompletableFuture<SendResult<String, String>> completableFuture =
//                kafkaTemplate.send("FirstTopic", message);
//
//        completableFuture.whenComplete((result, ex)->{
//            if( ex == null){
//                // success
//                log.info("SUCCESS!! This is the result: {}", result);
//            }else{
//                // fail
//                log.info("ERROR Kafka error happened", ex);
//            }
//        });
//
//        log.info("Produce Message - End {}", message);
//
//    }


}
