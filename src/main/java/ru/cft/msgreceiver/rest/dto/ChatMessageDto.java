package ru.cft.msgreceiver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.cft.msgreceiver.model.ChatMessageState;

public class ChatMessageDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String sender;
    private String text;

    public ChatMessageDto(Long id, String sender, String text) {
        this.id = id;
        this.sender = sender;
        this.text = text;
    }

    public ChatMessageDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
