package com.example.InventoryManagementSystem.Controller;

import com.example.InventoryManagementSystem.DTO.CustomerDTO;
import com.example.InventoryManagementSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO dto) {
        return customerService.createCustomer(dto);
    }

    // GET ALL
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(
            @PathVariable Integer id,
            @RequestBody CustomerDTO dto) {

        return customerService.updateCustomer(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }
}