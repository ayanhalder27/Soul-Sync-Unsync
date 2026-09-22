package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Services;
import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.service.ServicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service")
public class ServicesApi {

    ServicesService servicesService;

    public ServicesApi(ServicesService servicesService) {
        this.servicesService = servicesService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Services> getById(@PathVariable int id){
        return ResponseEntity.ok(servicesService.getServiceById(id));
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAlL(){
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody Services services){
        servicesService.createService(services);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@RequestBody Services services, @PathVariable int id){
        servicesService.updateService(services, id);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        servicesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
