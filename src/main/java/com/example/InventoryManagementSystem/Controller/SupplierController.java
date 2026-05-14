package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.SupplierDTO;
import com.example.InventoryManagementSystem.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")

public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // CREATE
    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO dto) {
        return supplierService.createSupplier(dto);
    }

    // GET ALL
    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable Integer id) {
        return supplierService.getSupplierById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(
            @PathVariable Integer id,
            @RequestBody SupplierDTO dto) {

        return supplierService.updateSupplier(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable Integer id) {
        return supplierService.deleteSupplier(id);
    }
}