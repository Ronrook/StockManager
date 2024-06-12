package com.ronrook.StockManager.application.ports.out;

import com.ronrook.StockManager.domain.model.Batch;

import java.util.List;

public interface BatchRepositoryPort {
    Batch save(Batch batch);
    Batch findById(String id);
    List<Batch> findAll();
    boolean deleteById(String id);
    Batch updateQuantity(String id, int quantity);
}
