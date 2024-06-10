package com.ronrook.StockManager.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data //getter y setter
@Document(collection = "products")
public class ProductMongoEntity {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String supplierId;
    private String categoryId;
    private Map<String, Object> additionalFields;
}