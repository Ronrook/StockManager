package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDTO {

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String supplierId;
    private String categoryId;
    private Map<String, Object> additionalFields;

    // Constructor que excluye 'additionalFields'
    public CreateProductDTO(String name, String description, int quantity, double price, String supplierId, String categoryId, Map<String, Object> additionalFields) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.additionalFields = additionalFields;
    }

    // Constructor que excluye 'additionalFields'
    public CreateProductDTO(String name, String description, int quantity, double price, String supplierId, String categoryId) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }
}
