package com.ronrook.StockManager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    private String id;
    private Date batchDate;
    private String productId;
    private Integer  initialQuantity;
    private Integer currentQuantity;
    private String location;
    private Map<String, Object> additionalFields;
}
