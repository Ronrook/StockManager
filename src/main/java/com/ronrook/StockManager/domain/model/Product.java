package com.ronrook.StockManager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String supplierId;
    private String categoryId;
    private Map<String, Object> additionalFields;

    // Constructor que excluye 'additionalFields'
    public Product(String id, String name, String description, int quantity, double price, String supplierId, String categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }

}
