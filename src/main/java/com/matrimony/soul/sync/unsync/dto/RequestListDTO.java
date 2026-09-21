package com.matrimony.soul.sync.unsync.dto;

import java.time.LocalDateTime;

public class RequestListDTO {
    private int id;
    private String profile_pic;
    private String name;
    private LocalDateTime sent_at;
    private int sender_id;

    public RequestListDTO(){}

    public RequestListDTO(int id, String profile_pic, String name, LocalDateTime sent_at, int sender_id) {
        this.id = id;
        this.profile_pic = profile_pic;
        this.name = name;
        this.sent_at = sent_at;
        this.sender_id = sender_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getSent_at() {
        return sent_at;
    }

    public void setSent_at(LocalDateTime sent_at) {
        this.sent_at = sent_at;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    @Override
    public String toString() {
        return "RequestListDTO{" +
                "id=" + id +
                ", profile_pic='" + profile_pic + '\'' +
                ", name='" + name + '\'' +
                ", sent_at=" + sent_at +
                ", sender_id=" + sender_id +
                '}';
    }
}
