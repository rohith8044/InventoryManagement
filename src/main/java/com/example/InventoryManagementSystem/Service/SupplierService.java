package com.example.InventoryManagementSystem.Service;

import com.example.InventoryManagementSystem.DTO.SupplierDTO;
import com.example.InventoryManagementSystem.Model.SupplierModel;
import com.example.InventoryManagementSystem.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // CREATE
    public SupplierDTO createSupplier(SupplierDTO dto) {

        SupplierModel supplier = new SupplierModel();

        supplier.setFirstName(dto.getFirstName());
        supplier.setLastName(dto.getLastName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());
        supplier.setCity(dto.getCity());
        supplier.setState(dto.getState());
        supplier.setCountry(dto.getCountry());
        supplier.setPostalCode(dto.getPostalCode());
        supplier.setStatus(dto.getStatus());

        SupplierModel savedSupplier = supplierRepository.save(supplier);

        return mapToDTO(savedSupplier);
    }

    // GET ALL
    public List<SupplierDTO> getAllSuppliers() {

        List<SupplierModel> suppliers = supplierRepository.findAll();

        return suppliers.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public SupplierDTO getSupplierById(Integer id) {

        SupplierModel supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier Not Found"));

        return mapToDTO(supplier);
    }

    // UPDATE
    public SupplierDTO updateSupplier(Integer id, SupplierDTO dto) {

        SupplierModel supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier Not Found"));

        supplier.setFirstName(dto.getFirstName());
        supplier.setLastName(dto.getLastName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());
        supplier.setCity(dto.getCity());
        supplier.setState(dto.getState());
        supplier.setCountry(dto.getCountry());
        supplier.setPostalCode(dto.getPostalCode());
        supplier.setStatus(dto.getStatus());

        SupplierModel updatedSupplier = supplierRepository.save(supplier);

        return mapToDTO(updatedSupplier);
    }

    // DELETE
    public String deleteSupplier(Integer id) {

        supplierRepository.deleteById(id);

        return "Supplier Deleted Successfully";
    }

    // DTO MAPPING
    private SupplierDTO mapToDTO(SupplierModel supplier) {

        return new SupplierDTO(
                supplier.getSupplierId(),
                supplier.getFirstName(),
                supplier.getLastName(),
                supplier.getEmail(),
                supplier.getPhone(),
                supplier.getAddress(),
                supplier.getCity(),
                supplier.getState(),
                supplier.getCountry(),
                supplier.getPostalCode(),
                supplier.getStatus()
        );
    }
}