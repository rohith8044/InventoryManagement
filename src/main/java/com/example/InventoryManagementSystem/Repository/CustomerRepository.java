package com.example.InventoryManagementSystem.Repository;

import com.example.InventoryManagementSystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}