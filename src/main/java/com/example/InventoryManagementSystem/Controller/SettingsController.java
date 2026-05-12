package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.SettingsDTO;
import com.example.InventoryManagementSystem.Model.Settings;
import com.example.InventoryManagementSystem.Service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsService service;

    // CREATE / UPDATE (UPSERT)
    @PostMapping
    public Settings createOrUpdate(@RequestBody SettingsDTO dto) {
        return service.createOrUpdate(dto);
    }

    // GET ALL
    @GetMapping
    public List<Settings> getAll() {
        return service.getAll();
    }

    // GET BY KEY
    @GetMapping("/{key}")
    public Settings getByKey(@PathVariable String key) {
        return service.getByKey(key);
    }

    // =========================
    // PUT - UPDATE ONLY VALUE
    // =========================
    @PutMapping("/{key}")
    public Settings updateSetting(@PathVariable String key,
                                  @RequestBody SettingsDTO dto) {
        return service.updateSetting(key, dto);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{key}")
    public String deleteSetting(@PathVariable String key) {
        service.deleteSetting(key);
        return "Setting deleted successfully";
    }
}