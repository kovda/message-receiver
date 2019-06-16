package ru.cft.msgreceiver.service;

import reactor.core.publisher.Flux;
import ru.cft.msgreceiver.model.ChatMessage;

public interface BadMessageService {
    Flux<ChatMessage> badMessages();
}
