package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Expense;
import com.matrimony.soul.sync.unsync.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public boolean addExpense(Expense expense){
        int rows = expenseRepository.save(expense);
        return rows>0;
    }

    public List<Expense> getExpenseByOrganizer(int organizerId){
        return expenseRepository.findByOrganizerID(organizerId);
    }

    public boolean deleteExpense(int id){
        int rows=expenseRepository.delete(id);
        return rows>0;
    }
}
