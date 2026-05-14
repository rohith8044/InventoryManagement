package com.example.InventoryManagementSystem.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String productName;
    private Long categoryId;
    private Long brandId;
    private String sku;
    private String description;
    private Double price;
}
