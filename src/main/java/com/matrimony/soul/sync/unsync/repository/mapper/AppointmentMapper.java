package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Appointment;
import com.matrimony.soul.sync.unsync.domain.AppointmentStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentMapper implements RowMapper<Appointment> {

    @Override
    public Appointment mapRow(ResultSet rs, int rowNum)throws SQLException{
        return new Appointment(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getInt("lawyer_id"),
                AppointmentStatus.valueOf(rs.getString("status")),
                rs.getTimestamp("appointment_time").toLocalDateTime()
        );

    }
}
