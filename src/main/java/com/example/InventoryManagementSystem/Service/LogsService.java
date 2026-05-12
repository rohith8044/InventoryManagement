package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.LogsDTO;
import com.example.InventoryManagementSystem.Model.Logs;
import com.example.InventoryManagementSystem.Repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {

    @Autowired
    private LogsRepository repository;

    public Logs createLog(LogsDTO dto) {
        Logs log = new Logs();
        log.setUserId(dto.getUserId());
        log.setAction(dto.getAction());
        log.setIpAddress(dto.getIpAddress());
        log.setUserAgent(dto.getUserAgent());

        return repository.save(log);
    }

    public Logs getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with id: " + id));
    }

    public Logs updateLog(Long id, LogsDTO dto) {
        Logs log = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with id: " + id));

        log.setUserId(dto.getUserId());
        log.setAction(dto.getAction());
        log.setIpAddress(dto.getIpAddress());
        log.setUserAgent(dto.getUserAgent());

        return repository.save(log);
    }

    public void deleteLog(Long id) {
        Logs log = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with id: " + id));

        repository.delete(log);
    }

    public List<Logs> getAllLogs() {
        return repository.findAll();
    }
}
