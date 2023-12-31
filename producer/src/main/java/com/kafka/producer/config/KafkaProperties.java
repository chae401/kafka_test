package com.kafka.producer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;
}
