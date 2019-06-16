package ru.cft.msgreceiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.cft.msgreceiver.model.ChatMessage;

@Service
public class DefaultBadChatMessageService implements BadMessageService {

    @Autowired
    private WebClient messageHandlerClient;

    @Override
    public Flux<ChatMessage> badMessages() {
        return messageHandlerClient.get()
                .uri("/messages/BAD")
                .exchange()
                .flatMapMany(r -> r.bodyToFlux(ChatMessage.class));
    }
}
