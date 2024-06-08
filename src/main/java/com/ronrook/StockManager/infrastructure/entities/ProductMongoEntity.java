package com.ronrook.StockManager.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@AllArgsConstructor // para que funcione las validaciones
@NoArgsConstructor // para que no de error al obtener el producto con el getProduct(Integer id)
@Data //getter y setter
@Document(collection = "products")
public class ProductMongoEntity {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String description;
    private Map<String, Object> additionalFields;
}