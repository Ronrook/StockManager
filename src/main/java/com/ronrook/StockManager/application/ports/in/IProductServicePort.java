package com.ronrook.StockManager.application.ports.in;

import com.ronrook.StockManager.domain.model.Product;

import java.util.List;

public interface IProductServicePort {
    Product addProduct(Product product);
    Product getProduct(String id);
    List<Product> listProducts();
    boolean removeProduct(String id);
    void updateProductQuantity(String id, int quantity);
}
