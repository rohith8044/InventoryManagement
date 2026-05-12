package com.example.InventoryManagementSystem.DTO;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class PaymentUpdateRequest {

    private BigDecimal paidAmount;
}
