package com.ronrook.StockManager.application.ports.in;

import com.ronrook.StockManager.application.ports.in.DTO.CreateProductDTO;
import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;

import java.util.List;

public interface IProductServicePort {
    ProductResponseDTO addProduct(CreateProductDTO product);
    ProductResponseDTO getProduct(String id);
    List<ProductResponseDTO> listProducts();
    boolean removeProduct(String id);
    void updateProductQuantity(String id, Integer quantity);
}
