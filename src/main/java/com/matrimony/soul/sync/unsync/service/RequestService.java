package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Partner;
import com.matrimony.soul.sync.unsync.domain.Request;
import com.matrimony.soul.sync.unsync.dto.RequestListDTO;
import com.matrimony.soul.sync.unsync.repository.RequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestService {
    RequestRepository requestRepository;
    PartnerService partnerService;

    public RequestService(RequestRepository requestRepository, PartnerService partnerService) {
        this.requestRepository = requestRepository;
        this.partnerService = partnerService;
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

    @Transactional
    public void acceptRequest(int request_id){
        Request request = requestRepository.getRequestData(request_id);
        Partner partner = new Partner();
        partner.setUser1_id(request.getReceiver_id());
        partner.setUser2_id(request.getSender_id());
        if(partnerService.addPartner(partner)){
            deleteRequest(request_id);
        }
    }
}
