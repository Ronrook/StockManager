package com.ronrook.StockManager.application.services;

import com.ronrook.StockManager.application.usecases.ProductUseCase;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.domain.ports.in.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.listProducts();
    }

    @Override
    public boolean removeProduct(String id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public void updateProductQuantity(String id, int quantity) {
        Product product = productRepository.getProduct(id);
        if (product != null) {
            product.setQuantity(quantity);
            productRepository.createProduct(product);
        }
    }
}
