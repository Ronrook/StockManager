package com.ronrook.StockManager.application.usecases;

import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.domain.ports.in.ProductRepository;
import com.ronrook.StockManager.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductRepository {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);

    }

    @Override
    public Product getProduct(String id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public List<Product> listProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public boolean deleteProduct(String id) {
        return productRepositoryPort.deleteById(id);

    }

    @Override
    public Optional<Product> updateProductQuantity(String id, int quantity) {
        return null;
    }
}
