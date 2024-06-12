package com.ronrook.StockManager.infrastructure.entities;

import com.ronrook.StockManager.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "batches")
public class BatchMongoEntity {
    @Id
    private String id;
    private Date batchDate;
    private Product product;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private String location;
    private Map<String, Object> additionalFields;
}