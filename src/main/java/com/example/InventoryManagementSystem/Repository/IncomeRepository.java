package com.example.InventoryManagementSystem.Repository;

import com.example.InventoryManagementSystem.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}