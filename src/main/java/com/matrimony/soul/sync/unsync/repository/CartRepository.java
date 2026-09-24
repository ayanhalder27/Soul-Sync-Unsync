package com.matrimony.soul.sync.unsync.repository;


import com.matrimony.soul.sync.unsync.domain.Cart;
import com.matrimony.soul.sync.unsync.domain.CartStatus;
import com.matrimony.soul.sync.unsync.repository.mapper.CartMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
        private final JdbcTemplate jdbcTemplate;

    public CartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cart> ALLOrderByOrganizerId(int organizerId){
        String sql= "SELECT c.id, c.client_id, c.service_id, c.status " +
                    "FROM Cart c " +
                    "JOIN Services s ON c.service_id = s.id " +
                    "WHERE s.organizer_id = ?";

        return jdbcTemplate.query(sql, new CartMapper(),organizerId);
    }

    public int updateStatus(int carId, CartStatus status){
        String sql= "UPDATE Cart SET status= ? WHERE id= ? ";
        return  jdbcTemplate.update(sql,status.name(),carId);
    }
}
