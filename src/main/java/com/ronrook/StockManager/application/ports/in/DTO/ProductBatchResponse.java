package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchResponse {

    private String name;
    private Integer standardQuantity;
    private String categoryId;
    private String supplierId;
}
