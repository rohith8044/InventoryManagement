package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
