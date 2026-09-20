package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("contact"),
                Gender.valueOf(rs.getString("gender")),
                rs.getString("password_hash"),
                Role.valueOf(rs.getString("role")),
                Religion.valueOf(rs.getString("religion")),
                SoulStatus.valueOf(rs.getString("soul-status")),
                rs.getString("profile_pic"),
                rs.getBoolean("visibility")

        );
    }
}
