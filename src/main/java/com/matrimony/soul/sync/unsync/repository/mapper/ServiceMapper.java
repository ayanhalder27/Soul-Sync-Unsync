package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {

    @Override
    public Service mapRow(ResultSet rs, int rowNUm) throws SQLException{
        return new Service(
                rs.getInt("id"),
                rs.getString("service_name"),
                rs.getString("description"),
                rs.getFloat("price"),
                rs.getInt("organizer_id")
        );
    }
}
