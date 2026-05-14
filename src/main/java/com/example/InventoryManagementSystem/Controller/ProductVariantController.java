package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.ProductVariantDTO;
import com.example.InventoryManagementSystem.Model.ProductVariant;
import com.example.InventoryManagementSystem.Repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
public class ProductVariantController {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    // CREATE VARIANT
    @PostMapping
    public ProductVariant createVariant(@RequestBody ProductVariantDTO dto) {

        ProductVariant variant = new ProductVariant();

        variant.setProductId(dto.getProductId());
        variant.setVariantName(dto.getVariantName());
        variant.setPrice(dto.getPrice());
        variant.setSku(dto.getSku());
        variant.setStatus("active");

        return productVariantRepository.save(variant);
    }

    // GET ALL VARIANTS
    @GetMapping
    public List<ProductVariant> getAllVariants() {
        return productVariantRepository.findAll();
    }

    // GET VARIANT BY ID
    @GetMapping("/{id}")
    public ProductVariant getVariantById(@PathVariable Long id) {
        return productVariantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found"));
    }

    // UPDATE VARIANT
    @PutMapping("/{id}")
    public ProductVariant updateVariant(@PathVariable Long id,
                                        @RequestBody ProductVariantDTO dto) {

        ProductVariant v = productVariantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found"));

        v.setProductId(dto.getProductId());
        v.setVariantName(dto.getVariantName());
        v.setPrice(dto.getPrice());
        v.setSku(dto.getSku());

        return productVariantRepository.save(v);
    }

    // DELETE VARIANT
    @DeleteMapping("/{id}")
    public String deleteVariant(@PathVariable Long id) {
        productVariantRepository.deleteById(id);
        return "Variant deleted successfully";
    }
}