package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Appointment;
import com.matrimony.soul.sync.unsync.repository.mapper.AppointmentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepository {
    private final JdbcTemplate jdbcTemplate;

    public AppointmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> finalByLawyerId (int lawyerId){
        String sql = "SELECT * FROM Appointments WHERE lawyer_id =?";
        return jdbcTemplate.query(sql,new AppointmentMapper(),lawyerId);
    }

    public int updateStatus(int appointmentId, String status){
        String sql = "UPDATE Appointments SET status = ? WHERE id =?";
        return jdbcTemplate.update(sql,status,appointmentId);
    }

    public int save(Appointment appointment){
        String sql = "INSERT INTO Appointments (client_id, lawyer_id, appointment_time, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                appointment.getClient_id(),
                appointment.getLawyer_id(),
                appointment.getAppointment_time(),
                appointment.getStatus() != null ? appointment.getStatus().name():"PENDING"
        );
    }
}
