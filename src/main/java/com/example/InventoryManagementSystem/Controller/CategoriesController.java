package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.Model.Category;
import com.example.InventoryManagementSystem.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category newCat) {
        Category c = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        c.setCategoryName(newCat.getCategoryName());
        c.setDescription(newCat.getDescription());

        return categoryRepository.save(c);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "Deleted successfully";
    }
}