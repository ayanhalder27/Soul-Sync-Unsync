package com.matrimony.soul.sync.unsync.dto;

import java.time.LocalDateTime;

public class ChatListDTO {
    private String profile_pic;
    private String name;
    private String message;
    private LocalDateTime sent_at;
    private int receiver_id;

    public ChatListDTO(){}

    public ChatListDTO(String profile_pic, String name, String message, LocalDateTime sent_at, int receiver_id) {
        this.profile_pic = profile_pic;
        this.name = name;
        this.message = message;
        this.sent_at = sent_at;
        this.receiver_id = receiver_id;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    @Override
    public String toString() {
        return "ChatListDTO{" +
                "profile_pic='" + profile_pic + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", sent_at=" + sent_at +
                ", receiver_id=" + receiver_id +
                '}';
    }
}
