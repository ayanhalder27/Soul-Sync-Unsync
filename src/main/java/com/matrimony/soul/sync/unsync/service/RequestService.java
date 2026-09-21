package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Request;
import com.matrimony.soul.sync.unsync.dto.RequestListDTO;
import com.matrimony.soul.sync.unsync.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestService {
    RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public int sendRequest(Request request){
        return requestRepository.sendRequest(request);
    }

    public int deleteRequest(int request_id){
        return requestRepository.deleteRequest(request_id);
    }

    public List<RequestListDTO> getRequestList(int receiver_id){
        return requestRepository.getRequestList(receiver_id);
    }
}
