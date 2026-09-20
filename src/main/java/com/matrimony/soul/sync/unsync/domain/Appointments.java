package com.matrimony.soul.sync.unsync.domain;

import java.time.LocalDateTime;

public class Appointments {
    private int id;
    private int client_id;
    private int lawyer_id;
    private Enum<AppointmentStatus> status;
    private LocalDateTime appointment_time;

    public Appointments(){}

    public Appointments(int id, int client_id, int lawyer_id, Enum<AppointmentStatus> status, LocalDateTime appointment_time) {
        this.id = id;
        this.client_id = client_id;
        this.lawyer_id = lawyer_id;
        this.status = status;
        this.appointment_time = appointment_time;
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

    public int getLawyer_id() {
        return lawyer_id;
    }

    public void setLawyer_id(int lawyer_id) {
        this.lawyer_id = lawyer_id;
    }

    public Enum<AppointmentStatus> getStatus() {
        return status;
    }

    public void setStatus(Enum<AppointmentStatus> status) {
        this.status = status;
    }

    public LocalDateTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalDateTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", lawyer_id=" + lawyer_id +
                ", status=" + status +
                ", appointment_time=" + appointment_time +
                '}';
    }
}
