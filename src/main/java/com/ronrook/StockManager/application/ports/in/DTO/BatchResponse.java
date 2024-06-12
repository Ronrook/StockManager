package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponse {
    
    private String id;
    private Date batchDate;
    private ProductBatchResponse product;
    private Integer  initialQuantity;
    private Integer currentQuantity;
    private String location;
}
