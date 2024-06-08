package com.ronrook.StockManager.domain.ports.in;

import com.ronrook.StockManager.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product createProduct(Product product);
    Product getProduct(String id);
    List<Product> listProducts();
    boolean deleteProduct(String id);
    Optional<Product> updateProductQuantity(String id, int quantity);
}
