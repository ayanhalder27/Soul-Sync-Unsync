package com.matrimony.soul.sync.unsync.domain;

public class Cart {
    private int id;
    private int client_id;
    private int service_id;
    private CartStatus status;

    public Cart(){}

    public Cart(int id, int client_id, int service_id, CartStatus status) {
        this.id = id;
        this.client_id = client_id;
        this.service_id = service_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", service_id=" + service_id +
                ", status=" + status +
                '}';
    }
}
