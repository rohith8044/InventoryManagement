package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.ExpenseDTO;
import com.example.InventoryManagementSystem.Model.Expense;

import java.util.List;

public interface ExpenseService {
    Expense createExpense(ExpenseDTO dto);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);
}
