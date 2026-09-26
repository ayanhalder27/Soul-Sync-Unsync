package com.matrimony.soul.sync.unsync.domain;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    @Positive(message = "Client ID must be a valid positive number")
    private int client_id;
    @Positive(message = "Lawyer ID must be a valid positive number")
    private int lawyer_id;
    @NotNull(message = "Appointment status cannot be null")
    private AppointmentStatus status;
    @NotNull(message = "Appointment time cannot be null")
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointment_time;

    public Appointment(){}

    public Appointment(int id, int client_id, int lawyer_id, AppointmentStatus status, LocalDateTime appointment_time) {
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

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
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
