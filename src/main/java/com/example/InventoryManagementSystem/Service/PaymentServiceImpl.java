package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.*;
import com.example.InventoryManagementSystem.Model.Payment;
import com.example.InventoryManagementSystem.Repository.PaymentRepository;
import com.example.InventoryManagementSystem.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repo;

    private PaymentResponseDTO mapToDTO(Payment p) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setPaymentId(p.getPaymentId());
        dto.setSaleId(p.getSaleId());
        dto.setPurchaseId(p.getPurchaseId());
        dto.setPaymentMethod(p.getPaymentMethod());
        dto.setAmount(p.getAmount());
        dto.setPaymentDate(p.getPaymentDate());
        dto.setStatus(p.getStatus());
        return dto;
    }

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {

        // SIMPLE RULE: only one should exist (sale OR purchase)
        if (dto.getSaleId() != null && dto.getPurchaseId() != null) {
            throw new RuntimeException("Only saleId OR purchaseId allowed");
        }

        Payment p = new Payment();
        p.setSaleId(dto.getSaleId());
        p.setPurchaseId(dto.getPurchaseId());
        p.setPaymentMethod(dto.getPaymentMethod());
        p.setAmount(dto.getAmount());
        p.setCreatedBy(dto.getCreatedBy());

        return mapToDTO(repo.save(p));
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        Payment p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return mapToDTO(p);
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO dto) {
        Payment p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        p.setPaymentMethod(dto.getPaymentMethod());
        p.setAmount(dto.getAmount());
        p.setSaleId(dto.getSaleId());
        p.setPurchaseId(dto.getPurchaseId());

        return mapToDTO(repo.save(p));
    }

    @Override
    public void deletePayment(Long id) {
        repo.deleteById(id);
    }
}