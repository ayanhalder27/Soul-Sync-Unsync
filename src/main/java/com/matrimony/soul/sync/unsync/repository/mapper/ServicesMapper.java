package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Services;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesMapper implements RowMapper<Services> {

    @Override
    public Services mapRow(ResultSet rs, int rowNUm) throws SQLException{
        return new Services(
                rs.getInt("id"),
                rs.getString("service_name"),
                rs.getString("description"),
                rs.getFloat("price"),
                rs.getInt("organizer_id")
        );
    }
}
