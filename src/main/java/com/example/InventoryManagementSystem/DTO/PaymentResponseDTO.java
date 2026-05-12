package com.example.InventoryManagementSystem.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class PaymentResponseDTO {

    private Long paymentId;
    private Long saleId;
    private Long purchaseId;
    private String paymentMethod;
    private BigDecimal amount;
    private OffsetDateTime paymentDate;
    private String status;
}
