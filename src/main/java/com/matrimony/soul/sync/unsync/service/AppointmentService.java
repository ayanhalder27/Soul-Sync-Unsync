package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Appointment;
import com.matrimony.soul.sync.unsync.domain.AppointmentStatus;
import com.matrimony.soul.sync.unsync.repository.AppointmentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final JdbcTemplate jdbcTemplate;

    public AppointmentService(AppointmentRepository appointmentRepository, JdbcTemplate jdbcTemplate) {
        this.appointmentRepository = appointmentRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> getAppointmentsForlawyer(int lawyerId){
        return appointmentRepository.finalByLawyerId(lawyerId);
    }

    public boolean updateAppointmentStatus(int appointmentId, String status){
        int rowAfftected =  appointmentRepository.updateStatus(appointmentId,status);
        return rowAfftected>0;
    }

    public boolean createAppointment(Appointment appointment){
        if(appointment.getStatus()==null){
            appointment.setStatus(AppointmentStatus.PENDING);
        }
        return appointmentRepository.save(appointment)>0;
    }


    @Transactional
    public void processUnsync(int client1Id, int client2Id) {
        String deletePartnerQuery = "DELETE FROM Partners WHERE (user1_id = ? AND user2_id = ?) OR (user1_id = ? AND user2_id = ?)";
        int partnersDeleted = jdbcTemplate.update(deletePartnerQuery, client1Id, client2Id, client2Id, client1Id);
        System.out.println("Partners deleted count: " + partnersDeleted);

        String updateStatusQuery = "UPDATE Users SET soul_status = 'DIVORSED' WHERE id = ? OR id = ?";
        int usersUpdated = jdbcTemplate.update(updateStatusQuery, client1Id, client2Id);
        System.out.println("Users updated count: " + usersUpdated);
    }

}
