package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.repository.mapper.ServiceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbcTemplate;

    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Service get(int id){
        return (Service) jdbcTemplate.queryForObject("SELECT * FROM Services WHERE id=?",new ServiceMapper(),id);
    }

    public int insert(Service service){
        return jdbcTemplate.update("INSERT INTO Services(service_name,description,price,organizer_id) VALUES(?, ?, ?,  ?);");


    }
}
