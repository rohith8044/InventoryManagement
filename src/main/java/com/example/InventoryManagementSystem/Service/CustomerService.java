package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.CustomerDTO;
import com.example.InventoryManagementSystem.Model.Customer;
import com.example.InventoryManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    public CustomerDTO createCustomer(CustomerDTO dto) {

        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setStatus(dto.getStatus());

        Customer savedCustomer = customerRepository.save(customer);

        return mapToDTO(savedCustomer);
    }

    // GET ALL
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public CustomerDTO getCustomerById(Integer id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        return mapToDTO(customer);
    }

    // UPDATE
    public CustomerDTO updateCustomer(Integer id, CustomerDTO dto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setStatus(dto.getStatus());

        Customer updatedCustomer = customerRepository.save(customer);

        return mapToDTO(updatedCustomer);
    }

    // DELETE
    public String deleteCustomer(Integer id) {

        customerRepository.deleteById(id);

        return "Customer Deleted Successfully";
    }

    // DTO MAPPING
    private CustomerDTO mapToDTO(Customer customer) {

        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getStatus()
        );
    }
}