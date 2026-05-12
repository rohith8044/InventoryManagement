package com.example.InventoryManagementSystem.Controller;


import com.example.InventoryManagementSystem.DTO.PaymentRequestDTO;
import com.example.InventoryManagementSystem.DTO.PaymentResponseDTO;
import com.example.InventoryManagementSystem.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public PaymentResponseDTO create(@RequestBody PaymentRequestDTO dto) {
        return service.createPayment(dto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDTO getById(@PathVariable Long id) {
        return service.getPaymentById(id);
    }

    @GetMapping
    public List<PaymentResponseDTO> getAll() {
        return service.getAllPayments();
    }

    @PutMapping("/{id}")
    public PaymentResponseDTO update(@PathVariable Long id,
                                     @RequestBody PaymentRequestDTO dto) {
        return service.updatePayment(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePayment(id);
        return "Payment deleted successfully";
    }
}
