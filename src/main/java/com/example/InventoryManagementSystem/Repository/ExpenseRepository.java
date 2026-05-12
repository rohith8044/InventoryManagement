package com.example.InventoryManagementSystem.Repository;

import com.example.InventoryManagementSystem.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
