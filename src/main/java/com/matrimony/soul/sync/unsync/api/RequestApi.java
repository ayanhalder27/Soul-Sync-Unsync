package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Request;
import com.matrimony.soul.sync.unsync.dto.RequestListDTO;
import com.matrimony.soul.sync.unsync.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/requests")
public class RequestApi {
    RequestService requestService;

    public RequestApi(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Void> sendRequest(@RequestParam int sender_id, @RequestParam int receiver_id){
        Request request = new Request();
        request.setSender_id(sender_id);
        request.setReceiver_id(receiver_id);
        requestService.sendRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{request_id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable int request_id){
        requestService.deleteRequest(request_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{receiver_id}")
    public ResponseEntity<List<RequestListDTO>> getRequestList(@PathVariable int receiver_id){
        return ResponseEntity.ok(requestService.getRequestList(receiver_id));
    }

    @PutMapping("/{request_id}")
    public ResponseEntity<Void> acceptRequest(@PathVariable int request_id){
        requestService.acceptRequest(request_id);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
    }
}
