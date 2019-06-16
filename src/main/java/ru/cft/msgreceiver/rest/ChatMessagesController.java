package ru.cft.msgreceiver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.cft.msgreceiver.model.ChatMessage;
import ru.cft.msgreceiver.rest.dto.ChatMessageDto;
import ru.cft.msgreceiver.service.BadMessageService;
import ru.cft.msgreceiver.service.SendService;

@RestController
@RequestMapping("/messages")
public class ChatMessagesController {

    @Autowired
    private SendService sendService;

    @Autowired
    private BadMessageService badMessageService;

    @PostMapping("/send")
    public Mono<Void> send(@RequestBody Mono<ChatMessageDto> messageDto) {
        return sendService.sendMessage(messageDto.map(m -> new ChatMessage(m.getSender(), m.getText())));
    }

    @GetMapping("/bad")
    public Flux<ChatMessageDto> badMessages() {
        return badMessageService
                .badMessages()
                .map(m -> new ChatMessageDto(m.getId(), m.getSender(), m.getText()));
    }

}
