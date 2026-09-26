package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Expense;
import com.matrimony.soul.sync.unsync.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizer/expense")
public class ExpenseApi {

    private final ExpenseService expenseService;

    public ExpenseApi(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> addExpense(@RequestBody Expense expense){
        boolean saved = expenseService.addExpense(expense);
        if(saved){
            return ResponseEntity.ok("Expense added successfully");
        }
        return ResponseEntity.badRequest().body("Failed to add expense.");
    }

    @GetMapping("/{organizerId}")
    public ResponseEntity<List<Expense>> getOrganizerExpense(@PathVariable int organizerId){
        List<Expense> expense = expenseService.getExpenseByOrganizer(organizerId);
        return ResponseEntity.ok(expense);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable int id){
        boolean deleted = expenseService.deleteExpense(id);
        if(deleted){
            return ResponseEntity.ok("Expense deleted successfully");
        }
        return ResponseEntity.badRequest().body("Expense not found");
    }
}
