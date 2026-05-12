package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.*;
import com.example.InventoryManagementSystem.Model.Purchase;
import com.example.InventoryManagementSystem.Model.PurchaseItem;
import com.example.InventoryManagementSystem.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseItemService purchaseItemService;

    // ================= CREATE PURCHASE =================
    public PurchaseResponse createPurchase(PurchaseRequest dto) {

        Purchase purchase = new Purchase();

        purchase.setSupplierId(dto.getSupplierId());
        purchase.setReferenceNo(dto.getReferenceNo());
        purchase.setPaidAmount(dto.getPaidAmount());
        purchase.setTax(dto.getTax());
        purchase.setDiscount(dto.getDiscount());
        purchase.setShippingCost(dto.getShippingCost());
        purchase.setNotes(dto.getNotes());
        purchase.setCreatedBy(dto.getCreatedBy());

        // build items
        List<PurchaseItem> items =
                purchaseItemService.buildItems(purchase, dto.getItems());

        purchase.setItems(items);

        // total calculation
        BigDecimal total = items.stream()
                .map(PurchaseItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        purchase.setTotalAmount(total);

        // grand total
        BigDecimal tax = dto.getTax() != null ? dto.getTax() : BigDecimal.ZERO;
        BigDecimal discount = dto.getDiscount() != null ? dto.getDiscount() : BigDecimal.ZERO;
        BigDecimal shipping = dto.getShippingCost() != null ? dto.getShippingCost() : BigDecimal.ZERO;
        BigDecimal paid = dto.getPaidAmount() != null ? dto.getPaidAmount() : BigDecimal.ZERO;

        BigDecimal grandTotal = total.add(tax).add(shipping).subtract(discount);
        purchase.setGrandTotal(grandTotal);

        // due calculation
        BigDecimal due = grandTotal.subtract(paid);
        purchase.setDueAmount(due);

        // payment status
        if (due.compareTo(BigDecimal.ZERO) <= 0) {
            purchase.setPaymentStatus("PAID");
        } else if (paid.compareTo(BigDecimal.ZERO) > 0) {
            purchase.setPaymentStatus("PARTIAL");
        } else {
            purchase.setPaymentStatus("UNPAID");
        }

        purchase.setStatus("PENDING");

        Purchase saved = purchaseRepository.save(purchase);

        return mapToResponse(saved);
    }

    // ================= GET ALL =================
    public List<PurchaseResponse> getAll() {

        return purchaseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ================= GET BY ID =================
    public PurchaseResponse getByIdResponse(Long id) {

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        return mapToResponse(purchase);
    }

    // ================= PAYMENT UPDATE =================
    public PurchaseResponse updatePayment(Long id, PaymentUpdateRequest request) {

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        BigDecimal paidAmount = request.getPaidAmount();
        if (paidAmount == null) paidAmount = BigDecimal.ZERO;

        purchase.setPaidAmount(paidAmount);

        BigDecimal due = purchase.getGrandTotal().subtract(paidAmount);
        purchase.setDueAmount(due);

        if (due.compareTo(BigDecimal.ZERO) <= 0) {
            purchase.setPaymentStatus("PAID");
        } else {
            purchase.setPaymentStatus("PARTIAL");
        }

        Purchase saved = purchaseRepository.save(purchase);

        return mapToResponse(saved);
    }

    // ================= DELETE =================
    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }

    // ================= RESPONSE MAPPING =================
    private PurchaseResponse mapToResponse(Purchase p) {

        PurchaseResponse r = new PurchaseResponse();

        r.setPurchaseId(p.getPurchaseId());
        r.setSupplierId(p.getSupplierId());
        r.setReferenceNo(p.getReferenceNo());
        r.setPurchaseDate(p.getPurchaseDate());

        r.setTotalAmount(p.getTotalAmount());
        r.setGrandTotal(p.getGrandTotal());
        r.setPaidAmount(p.getPaidAmount());
        r.setDueAmount(p.getDueAmount());

        r.setPaymentStatus(p.getPaymentStatus());
        r.setStatus(p.getStatus());

        r.setItems(
                p.getItems().stream().map(i -> {
                    PurchaseItemResponse dto = new PurchaseItemResponse();
                    dto.setProductId(i.getProductId());
                    dto.setVariantId(i.getVariantId());
                    dto.setQuantity(i.getQuantity());
                    dto.setPrice(i.getPrice());
                    dto.setSubtotal(i.getSubtotal());
                    return dto;
                }).toList()
        );

        return r;
    }
}