package com.matrimony.soul.sync.unsync.domain;

import java.time.LocalDateTime;

public class Invoice {

    private int id;
    private int client_id;
    private float subtotal;
    private float discount;
    private float total;
    private InvoiceStatus status;
    private LocalDateTime paid_at;
    private int payment_receiver;

    public Invoice(){}

    public Invoice(int id, int client_id, float subtotal, float discount, float total, InvoiceStatus status, LocalDateTime paid_at, int payment_receiver) {
        this.id = id;
        this.client_id = client_id;
        this.subtotal = subtotal;
        this.discount = discount;
        this.total = total;
        this.status = status;
        this.paid_at = paid_at;
        this.payment_receiver = payment_receiver;
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(LocalDateTime paid_at) {
        this.paid_at = paid_at;
    }

    public int getPayment_receiver() {
        return payment_receiver;
    }

    public void setPayment_receiver(int payment_receiver) {
        this.payment_receiver = payment_receiver;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", subtotal=" + subtotal +
                ", discount=" + discount +
                ", total=" + total +
                ", status=" + status +
                ", paid_at=" + paid_at +
                ", payment_receiver=" + payment_receiver +
                '}';
    }
}
