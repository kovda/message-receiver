package ru.cft.msgreceiver.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ChatMessage {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String sender;
    private String text;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ChatMessageState state;

    public ChatMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public ChatMessage() {
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

    public ChatMessageState getState() {
        return state;
    }

    public void setState(ChatMessageState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", state=" + state +
                '}';
    }
}
