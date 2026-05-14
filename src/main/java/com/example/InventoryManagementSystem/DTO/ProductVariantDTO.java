package com.example.InventoryManagementSystem.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantDTO {

    private Long productId;
    private String variantName;
    private Double price;
    private String sku;
}