package com.ronrook.StockManager.application.ports.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private String id;
    private String name;
    private String description;
    private Integer standardQuantity;
    private Double price;
    private String categoryId;
    private String supplierId;

}
