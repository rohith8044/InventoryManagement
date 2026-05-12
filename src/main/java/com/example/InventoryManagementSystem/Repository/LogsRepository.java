package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, Long> {
}
