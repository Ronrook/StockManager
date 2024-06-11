package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDTO {
    private String id;
    private String name;
    private String description;
    private Integer standardQuantity;
    private Double price;
    private String supplierId;
    private String categoryId;
    private Map<String, Object> additionalFields;


}
