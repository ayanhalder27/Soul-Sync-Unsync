package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Appointment;
import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Lawyer")
public class AppointmentApi {
    private final AppointmentService appointmentService;

    public AppointmentApi(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{lawyerId}/appointments")
    public ResponseEntity<List<Appointment>> getAppointment(@PathVariable int lawyerId){
       List<Appointment> appointments = appointmentService.getAppointmentsForlawyer(lawyerId);
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("/appointment")
    public ResponseEntity<String> createAppointment(@Valid @RequestBody Appointment appointment) {
        boolean created = appointmentService.createAppointment(appointment);
        if (created) {
            return ResponseEntity.ok("Appointment booked successfully.");
        }
        return ResponseEntity.badRequest().body("Failed to book appointment.");
    }


    @PatchMapping("/appointment/{appointmentId}/status")
    public ResponseEntity<String> updateAppointmentStatus(@PathVariable int appointmentId,@RequestParam String status){
        boolean updated = appointmentService.updateAppointmentStatus(appointmentId,status);
        if(updated){
            return ResponseEntity.ok("Appointment Status update Successfully.");
        }
        return ResponseEntity.badRequest().body("Failed to update appointment status.");
    }

    @PostMapping("/unsync")
    public ResponseEntity<String> unsyncPartners(@RequestParam int client1Id,@RequestParam int client2Id){
        appointmentService.processUnsync(client1Id,client2Id);
        return ResponseEntity.ok("Successfully processed divorce and unsynced the clients.");
    }



}
