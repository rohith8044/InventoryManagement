package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
