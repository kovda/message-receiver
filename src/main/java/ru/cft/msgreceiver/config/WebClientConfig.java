package ru.cft.msgreceiver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${message.handler.service.url}")
    private String messageHandlerUrl;

    @Bean
    public WebClient messageHandlerClient() {
        return WebClient.builder()
                .baseUrl(messageHandlerUrl)
                .build();
    }

}
