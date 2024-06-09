package com.ronrook.StockManager.application.services;

import com.ronrook.StockManager.application.ports.in.IProductServicePort;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.application.ports.out.IProductRepositoryPort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService implements IProductServicePort {

    private final IProductRepositoryPort productRepositoryPort;

    public ProductService(IProductRepositoryPort IProductRepositoryPort) {
        this.productRepositoryPort = IProductRepositoryPort;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepositoryPort.createProduct(product);
    }

    @Override
    public Product getProduct(String id) {
        return productRepositoryPort.getProduct(id);
    }

    @Override
    public List<Product> listProducts() {
        return productRepositoryPort.listProducts();
    }

    @Override
    public boolean removeProduct(String id) {
        return productRepositoryPort.deleteProduct(id);
    }

    @Override
    public void updateProductQuantity(String id, int quantity) {
        Product product = productRepositoryPort.getProduct(id);
        if (product != null) {
            product.setQuantity(quantity);
            productRepositoryPort.createProduct(product);
        }
    }
}
