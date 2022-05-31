package com.company.rest.models;

public class Message {
    private int userId;
    private int messageId;
    private String title;
    private String body;

    public Message(int userId, int messageId, String title, String body) {
        this.userId = userId;
        this.messageId = messageId;
        this.title = title;
        this.body = body;
    }

    public Message() {
        //EMPTY
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
