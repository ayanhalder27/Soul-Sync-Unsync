package com.matrimony.soul.sync.unsync.repository.mapper;

import com.matrimony.soul.sync.unsync.domain.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements RowMapper<Expense> {

    @Override
    public Expense mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Expense(
                rs.getInt("id"),
                rs.getString("expense_type"),
                rs.getFloat("amount"),
                rs.getInt("invoice_id"),
                rs.getInt("organizer_id")
        );
    }
}
