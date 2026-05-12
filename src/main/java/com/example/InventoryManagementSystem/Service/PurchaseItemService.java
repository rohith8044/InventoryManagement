package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.PurchaseItemRequest;
import com.example.InventoryManagementSystem.Model.Purchase;
import com.example.InventoryManagementSystem.Model.PurchaseItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseItemService {

    // Convert DTO → Entity + calculate subtotal
    public List<PurchaseItem> buildItems(Purchase purchase,
                                         List<PurchaseItemRequest> dtoList) {

        List<PurchaseItem> items = new ArrayList<>();

        for (PurchaseItemRequest dto : dtoList) {

            PurchaseItem item = new PurchaseItem();

            item.setPurchase(purchase);
            item.setProductId(dto.productId);
            item.setVariantId(dto.variantId);
            item.setQuantity(dto.quantity);
            item.setPrice(dto.price);

            BigDecimal qty = BigDecimal.valueOf(dto.quantity);
            BigDecimal subtotal = dto.price.multiply(qty);

            item.setSubtotal(subtotal);

            items.add(item);
        }

        return items;
    }
}