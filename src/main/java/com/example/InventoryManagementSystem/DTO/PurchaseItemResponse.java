package com.example.InventoryManagementSystem.DTO;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PurchaseItemResponse {

    private Long productId;
    private Long variantId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
}