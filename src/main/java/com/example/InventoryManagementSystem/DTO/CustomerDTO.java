package com.example.InventoryManagementSystem.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO {

    private Integer customerId;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String status;
}