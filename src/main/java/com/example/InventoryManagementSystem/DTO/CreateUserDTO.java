package com.example.InventoryManagementSystem.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    private String username;
    private String password;
    private String email;
    private String fullName;
}