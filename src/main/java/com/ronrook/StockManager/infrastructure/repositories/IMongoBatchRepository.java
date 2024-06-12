package com.ronrook.StockManager.infrastructure.repositories;

import com.ronrook.StockManager.infrastructure.entities.BatchMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMongoBatchRepository extends MongoRepository<BatchMongoEntity, String> {
}
