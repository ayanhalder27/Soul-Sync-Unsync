package com.matrimony.soul.sync.unsync.domain;

import java.time.LocalDateTime;

public class Chat {
    private int id;
    private int sender_id;
    private int receiver_id;
    private String message;
    private LocalDateTime sent_at;

    public Chat(){}

    public Chat(int id, int sender_id, int receiver_id, String message, LocalDateTime sent_at) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.sent_at = sent_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSent_at() {
        return sent_at;
    }

    public void setSent_at(LocalDateTime sent_at) {
        this.sent_at = sent_at;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", sender_id=" + sender_id +
                ", receiver_id=" + receiver_id +
                ", message='" + message + '\'' +
                ", sent_at=" + sent_at +
                '}';
    }
}
