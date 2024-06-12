package com.ronrook.StockManager.domain.model;

import lombok.*;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    private String id;
    private Date batchDate;
    private Product product;
    private Integer  initialQuantity;
    private Integer currentQuantity;
    private String location;
    private Map<String, Object> additionalFields;
}
