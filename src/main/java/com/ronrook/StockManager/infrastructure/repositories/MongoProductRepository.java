package com.ronrook.StockManager.infrastructure.repositories;

import com.ronrook.StockManager.infrastructure.entities.ProductMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductRepository extends MongoRepository<ProductMongoEntity, String> {
}
