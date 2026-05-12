package com.example.InventoryManagementSystem.DTO;

import java.math.BigDecimal;

public class PurchaseItemRequest {

    public Long productId;
    public Long variantId;

    public Integer quantity;
    public BigDecimal price;

    public BigDecimal discount;
    public BigDecimal tax;
}