package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.IncomeDTO;
import com.example.InventoryManagementSystem.DTO.ExpenseDTO;
import com.example.InventoryManagementSystem.Model.Income;
import com.example.InventoryManagementSystem.Model.Expense;
import com.example.InventoryManagementSystem.Service.IncomeService;
import com.example.InventoryManagementSystem.Service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinanceAccountingController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private ExpenseService expenseService;

    // ================= INCOME =================

    @PostMapping("/income")
    public Income createIncome(@RequestBody IncomeDTO dto) {
        return incomeService.createIncome(dto);
    }

    @GetMapping("/income")
    public List<Income> getIncome() {
        return incomeService.getAllIncome();
    }

    // ✅ GET INCOME BY ID
    @GetMapping("/income/{id}")
    public Income getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    // ✅ UPDATE INCOME
    @PutMapping("/income/{id}")
    public Income updateIncome(@PathVariable Long id,
                               @RequestBody IncomeDTO dto) {
        return incomeService.updateIncome(id, dto);
    }

    // ✅ DELETE INCOME
    @DeleteMapping("/income/{id}")
    public String deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return "Income deleted successfully";
    }

    // ================= EXPENSE =================

    @PostMapping("/expense")
    public Expense createExpense(@RequestBody ExpenseDTO dto) {
        return expenseService.createExpense(dto);
    }

    @GetMapping("/expense")
    public List<Expense> getExpense() {
        return expenseService.getAllExpenses();
    }

    // ✅ GET EXPENSE BY ID
    @GetMapping("/expense/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // ✅ UPDATE EXPENSE
    @PutMapping("/expense/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody ExpenseDTO dto) {
        return expenseService.updateExpense(id, dto);
    }

    // ✅ DELETE EXPENSE
    @DeleteMapping("/expense/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}