package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
