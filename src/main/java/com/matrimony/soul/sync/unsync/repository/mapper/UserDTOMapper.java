package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Gender;
import com.matrimony.soul.sync.unsync.domain.Religion;
import com.matrimony.soul.sync.unsync.domain.SoulStatus;
import com.matrimony.soul.sync.unsync.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDTOMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("contact"),
                Gender.valueOf(rs.getString("gender")),
                Religion.valueOf(rs.getString("religion")),
                SoulStatus.valueOf(rs.getString("soul_status")),
                rs.getString("profile_pic"),
                rs.getInt("partners")
        );
    }
}
