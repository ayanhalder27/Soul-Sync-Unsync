package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Cart;
import com.matrimony.soul.sync.unsync.domain.CartStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Cart(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getInt("service_id"),
                CartStatus.valueOf(rs.getString("status"))
        );
    }
}
