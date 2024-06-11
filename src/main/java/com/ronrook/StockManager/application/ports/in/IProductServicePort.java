package com.ronrook.StockManager.application.ports.in;

import com.ronrook.StockManager.application.ports.in.DTO.ProductRequest;
import com.ronrook.StockManager.application.ports.in.DTO.ProductResponse;

import java.util.List;

public interface IProductServicePort {
    ProductResponse addProduct(ProductRequest product);
    ProductResponse getProduct(String id);
    List<ProductResponse> listProducts();
    boolean removeProduct(String id);
    void updateProductQuantity(String id, Integer quantity);
}
