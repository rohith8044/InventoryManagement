package com.example.InventoryManagementSystem.DTO;

import com.example.InventoryManagementSystem.Model.PurchaseItem;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PurchaseRequest {

    private Long supplierId;
    private String referenceNo;

    private BigDecimal paidAmount;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal shippingCost;

    private String notes;
    private Long createdBy;

    private List<PurchaseItemRequest> items;
}
