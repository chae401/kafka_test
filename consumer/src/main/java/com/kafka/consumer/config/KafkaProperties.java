package com.kafka.consumer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    public static final String CONSUMER_GROUP_ID = "testGroup";
    public static final String TOPIC = "CafeTopic";

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;
}
