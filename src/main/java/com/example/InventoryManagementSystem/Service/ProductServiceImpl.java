package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.ProductDTO;
import com.example.InventoryManagementSystem.Model.Product;
import com.example.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO dto) {
        Product p = new Product();
        p.setProductName(dto.getProductName());
        p.setCategoryId(dto.getCategoryId());
        p.setBrandId(dto.getBrandId());
        p.setSku(dto.getSku());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, ProductDTO dto) {
        Product p = getProductById(id);

        p.setProductName(dto.getProductName());
        p.setCategoryId(dto.getCategoryId());
        p.setBrandId(dto.getBrandId());
        p.setSku(dto.getSku());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setUpdatedAt(LocalDateTime.now());

        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
