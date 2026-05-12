package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}