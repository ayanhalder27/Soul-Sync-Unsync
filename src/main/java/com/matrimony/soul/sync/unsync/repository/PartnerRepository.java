package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Partner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerRepository {
    JdbcTemplate jdbcTemplate;

    public PartnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addPartner(Partner partner){
        return jdbcTemplate.update("INSERT INTO Partners (user1_id, user2_id) VALUES (?, ?)",
                partner.getUser1_id(),
                partner.getUser2_id());
    }

    public int count(int user_id){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM Partners where user1_id = ? OR user2_id = ?", Integer.class, user_id, user_id);
    }
}
