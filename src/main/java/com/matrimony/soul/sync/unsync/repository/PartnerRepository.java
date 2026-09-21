package com.matrimony.soul.sync.unsync.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerRepository {
    JdbcTemplate jdbcTemplate;

    public PartnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
