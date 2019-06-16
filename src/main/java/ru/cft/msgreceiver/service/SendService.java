package ru.cft.msgreceiver.service;

import reactor.core.publisher.Mono;
import ru.cft.msgreceiver.model.ChatMessage;

public interface SendService {
    Mono<Void> sendMessage(Mono<ChatMessage> message);
}
