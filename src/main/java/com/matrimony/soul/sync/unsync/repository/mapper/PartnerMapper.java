package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Partner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PartnerMapper implements RowMapper<Partner> {
    @Override
    public Partner mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Partner(rs.getInt("id"),
                rs.getInt("user1_id"),
                rs.getInt("user2_id"),
                rs.getObject("connected_at", LocalDateTime.class));
    }
}
