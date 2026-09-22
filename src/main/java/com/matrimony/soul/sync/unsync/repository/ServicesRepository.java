package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.repository.mapper.ServicesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.matrimony.soul.sync.unsync.domain.Services;

import java.util.List;

@Repository
public class ServicesRepository {
    private final JdbcTemplate jdbcTemplate;

    public ServicesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Services get(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Services WHERE id=?",new ServicesMapper(),id);
    }

    public List<Services> getAll(){
        return jdbcTemplate.query("SELECT * FROM Services", new ServicesMapper());
    }

    public int insert(Services services){
        return jdbcTemplate.update("INSERT INTO Services(service_name,description,price,organizer_id) VALUES(?, ?, ?,  ?);",
                services.getService_name(),
                services.getDescription(),
                services.getPrice(),
                services.getOrganizer_id());
    }

    public int update(Services services, int id){
        return jdbcTemplate.update(
                "UPDATE Services SET service_name=?, description=?,price=?,organizer_id=? WHERE id=?",
                services.getService_name(),
                services.getDescription(),
                services.getPrice(),
                services.getOrganizer_id()
        );
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM Services WHERE id=?;",id);
    }
}
