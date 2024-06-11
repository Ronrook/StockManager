package com.ronrook.StockManager.domain.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private Integer standardQuantity;
    private Double price;
    private String supplierId;
    private String categoryId;
    private Map<String, Object> additionalFields;


}
