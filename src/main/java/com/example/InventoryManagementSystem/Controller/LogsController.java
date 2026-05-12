package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.LogsDTO;
import com.example.InventoryManagementSystem.Model.Logs;
import com.example.InventoryManagementSystem.Service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogsController {

    @Autowired
    private LogsService service;

    // CREATE LOG
    @PostMapping
    public Logs createLog(@RequestBody LogsDTO dto) {
        return service.createLog(dto);
    }

    // GET ALL LOGS
    @GetMapping
    public List<Logs> getAll() {
        return service.getAllLogs();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public Logs getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // =========================
    // UPDATE LOG (PUT)
    // =========================
    @PutMapping("/{id}")
    public Logs updateLog(@PathVariable Long id,
                          @RequestBody LogsDTO dto) {
        return service.updateLog(id, dto);
    }

    // =========================
    // DELETE LOG
    // =========================
    @DeleteMapping("/{id}")
    public String deleteLog(@PathVariable Long id) {
        service.deleteLog(id);
        return "Log deleted successfully";
    }
}