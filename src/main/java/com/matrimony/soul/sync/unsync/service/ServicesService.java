package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Services;
import com.matrimony.soul.sync.unsync.repository.ServicesRepository;
import com.matrimony.soul.sync.unsync.repository.UserRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ser.std.DelegatingSerializer;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;
    private final UserRepository userRepository;

    public ServicesService(ServicesRepository servicesRepository,UserRepository userRepository){
        this.servicesRepository = servicesRepository;
        this.userRepository=userRepository;
    }

    public List<Services> getAllServices(){
        return servicesRepository.getAll();
    }

    public Services getServiceById(int id){
        return servicesRepository.get(id);
    }

    public int createService(Services services){
        if(userRepository.get(services.getOrganizer_id()) == null && services.getPrice()<0){
            throw new IllegalArgumentException("Organizer is not found and price is negative");
        }
        if(userRepository.get(services.getOrganizer_id()) == null )
            throw new IllegalArgumentException("Organizer is not found");
        if(services.getPrice()<0)
            throw new IllegalArgumentException("price is negative");

        return servicesRepository.insert(services);
    }

    public int updateService(Services services,int id){
        if(userRepository.get(services.getOrganizer_id()) == null && services.getPrice()<0){
            throw new IllegalArgumentException("Organizer is not found and price is negative");
        }
        if(userRepository.get(services.getOrganizer_id()) == null )
            throw new IllegalArgumentException("Organizer is not found");
        if(services.getPrice()<0)
            throw new IllegalArgumentException("price is negative");

        return servicesRepository.update(services,id);

    }

    public int delete(int id){
        if(servicesRepository.get(id)!=null)
            return servicesRepository.delete(id);
        throw new IllegalArgumentException("Service not found");
    }

}




