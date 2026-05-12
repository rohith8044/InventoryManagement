package com.example.InventoryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long saleId;
    private Long purchaseId;

    private String paymentMethod;

    @Column(nullable = false)
    private BigDecimal amount;

    private OffsetDateTime paymentDate = OffsetDateTime.now();

    private String status = "COMPLETED";

    private Long createdBy;

    private OffsetDateTime createdAt = OffsetDateTime.now();
}