package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.Model.Brand;
import com.example.InventoryManagementSystem.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    // CREATE BRAND
    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    // GET ALL
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    // 🔥 FIXED UPDATE (IMPORTANT)
    @PutMapping("/{id}")
    public Brand updateBrand(@PathVariable Long id, @RequestBody Brand request) {

        Brand existing = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        // update only safe fields
        existing.setBrandName(request.getBrandName());
        existing.setDescription(request.getDescription());
        existing.setStatus(request.getStatus());

        // 🔥 IMPORTANT: NEVER TOUCH createdAt
        // existing.setCreatedAt(...) ❌ REMOVE THIS ANYWHERE IN PROJECT

        return brandRepository.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable Long id) {
        brandRepository.deleteById(id);
        return "Brand deleted successfully";
    }
}