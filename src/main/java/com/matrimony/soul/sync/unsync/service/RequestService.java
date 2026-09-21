package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Request;
import com.matrimony.soul.sync.unsync.repository.RequestRepository;
import org.springframework.stereotype.Service;

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
}
