package com.company.rest.dtos;

import com.company.rest.models.Message;

public class MessageDto {
    private Message[] messages;

    public MessageDto(Message[] messages) {
        this.messages = messages;
    }

    public MessageDto() {
        //EMPTY
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
