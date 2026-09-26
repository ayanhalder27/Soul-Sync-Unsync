package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Expense;
import com.matrimony.soul.sync.unsync.repository.mapper.ExpenseMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Expense expense){
        String sql = "INSERT INTO Expenses (expense_type, amount, inovice_id, organizer_id) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,
                    expense.getExpense_type(),
                    expense.getAmount(),
                    expense.getInvoice_id(),
                    expense.getOrganizer_id()
                );
    }

    public List<Expense> findByOrganizerID(int organizer_id){
        String sql = "SELECT id, expense_type, amount, invoice_id, organizer_id FROM Expenses WHERE organizer_id=?";
        return jdbcTemplate.query(sql,new ExpenseMapper(),organizer_id);
    }
}
