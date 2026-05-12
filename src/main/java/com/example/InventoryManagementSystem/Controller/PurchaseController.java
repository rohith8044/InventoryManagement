package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.*;
import com.example.InventoryManagementSystem.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // ================= CREATE =================
    @PostMapping
    public PurchaseResponse create(@RequestBody PurchaseRequest dto) {
        return purchaseService.createPurchase(dto);
    }

    // ================= GET ALL (FIXED) =================
    @GetMapping
    public List<PurchaseResponse> getAll() {
        return purchaseService.getAll();
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public PurchaseResponse getById(@PathVariable Long id) {
        return purchaseService.getByIdResponse(id);
    }

    // ================= PAYMENT UPDATE =================
    @PutMapping("/{id}/payment")
    public PurchaseResponse updatePayment(
            @PathVariable Long id,
            @RequestBody PaymentUpdateRequest request) {

        return purchaseService.updatePayment(id, request);
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        purchaseService.delete(id);
        return "Purchase deleted successfully";
    }
}