package com.example.InventoryManagementSystem.Service;


import com.example.InventoryManagementSystem.DTO.ProductDTO;
import com.example.InventoryManagementSystem.Model.Product;
import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO dto);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, ProductDTO dto);

    void deleteProduct(Long id);
}