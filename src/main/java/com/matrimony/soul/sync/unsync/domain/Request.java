package com.matrimony.soul.sync.unsync.domain;

import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class Request {
    private int id;

    @Positive(message = "Sender ID must be positive")
    private Integer sender_id;

    @Positive(message = "Receiver ID must be positive")
    private Integer receiver_id;

    private LocalDateTime sent_at;

    public Request(){}

    public Request(int id, Integer sender_id, Integer receiver_id, LocalDateTime sent_at) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.sent_at = sent_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public Integer getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public LocalDateTime getSent_at() {
        return sent_at;
    }

    public void setSent_at(LocalDateTime sent_at) {
        this.sent_at = sent_at;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", sender_id=" + sender_id +
                ", receiver_id=" + receiver_id +
                ", sent_at=" + sent_at +
                '}';
    }
}
