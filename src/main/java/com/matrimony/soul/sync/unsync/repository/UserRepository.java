package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Gender;
import com.matrimony.soul.sync.unsync.domain.Religion;
import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.dto.UserDTO;
import com.matrimony.soul.sync.unsync.repository.mapper.UserDTOMapper;
import com.matrimony.soul.sync.unsync.repository.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Users WHERE id=?", new UserMapper(), id);
    }

    public int insert(User user){
        return jdbcTemplate.update("INSERT INTO Users(name, username, email, contact, gender, password_hash, role, religion, profile_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getContact(),
                user.getGender().name(),
                user.getPassword_hash(),
                user.getRole().name(),
                user.getReligion().name(),
                user.getProfile_pic());
    }

    public int update(User user, int id){
        return jdbcTemplate.update(
                "UPDATE Users SET name = ?, username = ?, email = ?, contact = ?, gender = ?, password_hash = ?, role = ?, religion = ?, soul_status = ?, profile_pic = ? WHERE id = ?",
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getContact(),
                user.getGender().name(),
                user.getPassword_hash(),
                user.getRole().name(),
                user.getReligion().name(),
                user.getSoulStatus().name(),
                user.getProfile_pic(),
                id
        );
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM Users WHERE id = ?;",id);
    }

    public List<UserDTO> Suggestions(Gender myGender, Religion religion){
        return jdbcTemplate.query("SELECT id, name, username, email, contact, gender, religion, soul_status, profile_pic, (SELECT count(*) FROM Partners where user1_id = Users.id OR user2_id = Users.id) AS partners FROM Users WHERE role = 'CLIENT' AND visibility = 1 AND gender != ? AND  religion = ?;",
                new UserDTOMapper(),
                myGender.toString(),
                religion.toString());
    }



}
