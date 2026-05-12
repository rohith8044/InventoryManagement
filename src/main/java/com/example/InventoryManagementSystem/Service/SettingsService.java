package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.SettingsDTO;
import com.example.InventoryManagementSystem.Model.Settings;
import com.example.InventoryManagementSystem.Repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository repository;

    public Settings createOrUpdate(SettingsDTO dto) {
        Optional<Settings> existing = repository.findBySettingKey(dto.getSettingKey());

        Settings settings;

        if (existing.isPresent()) {
            settings = existing.get();
            settings.setSettingValue(dto.getSettingValue());
        } else {
            settings = new Settings();
            settings.setSettingKey(dto.getSettingKey());
            settings.setSettingValue(dto.getSettingValue());
        }

        return repository.save(settings);
    }
    // UPDATE ONLY
    public Settings updateSetting(String key, SettingsDTO dto) {
        Settings settings = repository.findBySettingKey(key)
                .orElseThrow(() -> new RuntimeException("Setting not found"));

        settings.setSettingValue(dto.getSettingValue());

        return repository.save(settings);
    }

    // DELETE
    public void deleteSetting(String key) {
        Settings settings = repository.findBySettingKey(key)
                .orElseThrow(() -> new RuntimeException("Setting not found"));

        repository.delete(settings);
    }

    public List<Settings> getAll() {
        return repository.findAll();
    }

    public Settings getByKey(String key) {
        return repository.findBySettingKey(key)
                .orElseThrow(() -> new RuntimeException("Setting not found"));
    }
}
