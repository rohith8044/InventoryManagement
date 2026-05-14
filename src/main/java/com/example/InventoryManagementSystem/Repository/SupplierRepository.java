package com.example.InventoryManagementSystem.Repository;

import com.example.InventoryManagementSystem.Model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierModel, Integer> {
}