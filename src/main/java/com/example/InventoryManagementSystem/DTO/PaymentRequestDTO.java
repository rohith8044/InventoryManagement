package com.example.InventoryManagementSystem.DTO;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    private Long saleId;
    private Long purchaseId;
    private String paymentMethod;
    private BigDecimal amount;
    private Long createdBy;
}