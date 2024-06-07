package com.ronrook.StockManager.domain.ports.in;

import com.ronrook.StockManager.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product save(Product product);
    Product findById(String id);
    List<Product> findAll();
    void deleteById(String id);
}
