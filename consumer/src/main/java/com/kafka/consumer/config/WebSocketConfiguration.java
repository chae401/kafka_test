package com.kafka.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // msg Broker에 의한 Websocket message 핸들링 허용
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    // to configure the message broker
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/topic"); // 발행자가 '/topic'의 경로로 메시지를 주면 구독자들에게 전달
        registry.setApplicationDestinationPrefixes("/app"); // 발생자가 '/app'의 경로로 메시지를 주면 가공을 해서 구독자들에게 전달
    }
    // to register the '/cafe' endpoint for websocket connections
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/cafe-test");
//                .setAllowedOrigins("http://localhost:10002")
//                .withSockJS();
    }


}
