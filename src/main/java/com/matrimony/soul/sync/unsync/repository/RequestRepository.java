package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Request;
import com.matrimony.soul.sync.unsync.dto.RequestListDTO;
import com.matrimony.soul.sync.unsync.repository.mapper.RequestMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    public List<RequestListDTO> getRequestList(int receiver_id){
        return jdbcTemplate.query("SELECT Requests.id, profile_pic, name, sent_at, sender_id FROM Requests inner join Users on sender_id = Users.id where receiver_id = ?",
                (rs, rowNum) -> {
                    return new RequestListDTO(rs.getInt("id"),
                            rs.getString("profile_pic"),
                            rs.getString("name"),
                            rs.getObject("sent_at", LocalDateTime.class),
                            rs.getInt("sender_id"));
                }, receiver_id);
    }

    public Request getRequestData(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Requests WHERE id = ?", new RequestMapper(), id);
    }
}
