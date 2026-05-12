package com.example.InventoryManagementSystem.Repository;


import com.example.InventoryManagementSystem.Model.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingsRepository extends JpaRepository<Settings, Long> {
    Optional<Settings> findBySettingKey(String settingKey);
}