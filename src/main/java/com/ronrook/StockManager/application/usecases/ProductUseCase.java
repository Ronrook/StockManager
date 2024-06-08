package com.ronrook.StockManager.application.usecases;

import com.ronrook.StockManager.domain.model.Product;

import java.util.List;

public interface ProductUseCase {
    Product addProduct(Product product);
    Product getProduct(String id);
    List<Product> listProducts();
    boolean removeProduct(String id);
    void updateProductQuantity(String id, int quantity);
}
