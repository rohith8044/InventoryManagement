package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.PaymentRequestDTO;
import com.example.InventoryManagementSystem.DTO.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    PaymentResponseDTO createPayment(PaymentRequestDTO dto);

    PaymentResponseDTO getPaymentById(Long id);

    List<PaymentResponseDTO> getAllPayments();

    PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO dto);

    void deletePayment(Long id);
}
