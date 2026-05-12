package com.example.InventoryManagementSystem.DTO;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class PurchaseResponse {

    private Long purchaseId;
    private Long supplierId;
    private String referenceNo;
    private LocalDate purchaseDate;

    private BigDecimal totalAmount;
    private BigDecimal grandTotal;
    private BigDecimal paidAmount;
    private BigDecimal dueAmount;

    private String paymentStatus;
    private String status;

    private List<PurchaseItemResponse> items;
}