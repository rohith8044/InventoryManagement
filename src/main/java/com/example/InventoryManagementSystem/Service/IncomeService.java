package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.IncomeDTO;
import com.example.InventoryManagementSystem.Model.Income;

import java.util.List;

public interface IncomeService {
    Income createIncome(IncomeDTO dto);
    List<Income> getAllIncome();
    Income getIncomeById(Long id);
    Income updateIncome(Long id, IncomeDTO dto);
    void deleteIncome(Long id);
}