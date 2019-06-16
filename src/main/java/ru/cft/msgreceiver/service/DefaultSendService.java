package ru.cft.msgreceiver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cft.msgreceiver.model.ChatMessage;

@Service
public class DefaultSendService implements SendService {

    private static final String POSTFIX_EXCHANGE = "_ex";

    private static final Logger log = LoggerFactory.getLogger(DefaultSendService.class);

    @Value("${rabbit.queue.massages.channel}")
    private String messagesChannel;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Mono<Void> sendMessage(Mono<ChatMessage> message) {
        return message
                .doOnNext(c -> {
                            log.info("Send message {} ", c);
                            rabbitTemplate.convertAndSend(messagesChannel + POSTFIX_EXCHANGE, "", c);
                        }
                ).then();
    }
}
