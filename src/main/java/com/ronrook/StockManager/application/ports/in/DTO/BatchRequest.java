package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchRequest {

    private String id;
    private Date batchDate;
    private String productId;
    private Integer  initialQuantity;
    private Integer currentQuantity;
    private String location;
    private Map<String, Object> additionalFields;
}
