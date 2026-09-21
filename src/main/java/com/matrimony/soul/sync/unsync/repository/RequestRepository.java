package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepository {
    JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int sendRequest(Request request){
        return jdbcTemplate.update("INSERT INTO Requests (sender_id, receiver_id) VALUES (?, ?)",
                request.getSender_id(),
                request.getReceiver_id());
    }

    public int deleteRequest(int request_id){
        return jdbcTemplate.update("DELETE FROM Requests WHERE id = ?", request_id);
    }
}
