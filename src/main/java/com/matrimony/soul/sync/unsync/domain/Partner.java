package com.matrimony.soul.sync.unsync.domain;

import java.time.LocalDateTime;

public class Partner {
    private int id;
    private int user1_id;
    private int user2_id;
    private LocalDateTime connected_at;

    public Partner(){}

    public Partner(int id, int user1_id, int user2_id, LocalDateTime connected_at) {
        this.id = id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.connected_at = connected_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(int user1_id) {
        this.user1_id = user1_id;
    }

    public int getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(int user2_id) {
        this.user2_id = user2_id;
    }

    public LocalDateTime getConnected_at() {
        return connected_at;
    }

    public void setConnected_at(LocalDateTime connected_at) {
        this.connected_at = connected_at;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", user1_id=" + user1_id +
                ", user2_id=" + user2_id +
                ", connected_at=" + connected_at +
                '}';
    }
}
