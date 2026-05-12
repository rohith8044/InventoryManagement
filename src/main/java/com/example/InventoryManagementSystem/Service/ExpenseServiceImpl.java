package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.ExpenseDTO;
import com.example.InventoryManagementSystem.Model.Expense;
import com.example.InventoryManagementSystem.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    @Override
    public Expense createExpense(ExpenseDTO dto) {
        Expense e = new Expense();
        e.setCategory(dto.category);
        e.setDescription(dto.description);
        e.setAmount(dto.amount);
        e.setExpenseDate(dto.expenseDate);
        e.setCreatedBy(dto.createdBy);
        return repo.save(e);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense e = repo.findById(id).orElseThrow();

        e.setCategory(dto.category);
        e.setDescription(dto.description);
        e.setAmount(dto.amount);
        e.setExpenseDate(dto.expenseDate);

        return repo.save(e);
    }

    @Override
    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }
}
