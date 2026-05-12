package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.IncomeDTO;
import com.example.InventoryManagementSystem.Model.Income;
import com.example.InventoryManagementSystem.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository repo;

    @Override
    public Income createIncome(IncomeDTO dto) {
        Income i = new Income();
        i.setSource(dto.source);
        i.setDescription(dto.description);
        i.setAmount(dto.amount);
        i.setIncomeDate(dto.incomeDate);
        i.setCreatedBy(dto.createdBy);
        return repo.save(i);
    }

    @Override
    public List<Income> getAllIncome() {
        return repo.findAll();
    }

    @Override
    public Income getIncomeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Income updateIncome(Long id, IncomeDTO dto) {
        Income i = repo.findById(id).orElseThrow();

        i.setSource(dto.source);
        i.setDescription(dto.description);
        i.setAmount(dto.amount);
        i.setIncomeDate(dto.incomeDate);

        return repo.save(i);
    }

    @Override
    public void deleteIncome(Long id) {
        repo.deleteById(id);
    }
}
