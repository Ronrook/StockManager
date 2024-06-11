package com.ronrook.StockManager.application.ports.out;

import com.ronrook.StockManager.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepositoryPort {

    Product createProduct(Product product);
    Product findById(String id);
    List<Product> findAll();
    boolean deleteById(String id);
    Optional<Product> updateProductQuantity(String id, int quantity);
}
