package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Chat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ChatMapper implements RowMapper<Chat> {
    @Override
    public Chat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Chat(
                rs.getInt("id"),
                rs.getInt("sender_id"),
                rs.getInt("receiver_id"),
                rs.getString("message"),
                rs.getObject("sent_at", LocalDateTime.class)
        );
    }
}
