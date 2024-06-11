package com.ronrook.StockManager.application.services;

import com.ronrook.StockManager.application.mappers.ProductMapper;
import com.ronrook.StockManager.application.ports.in.DTO.ProductRequest;
import com.ronrook.StockManager.application.ports.in.IProductServicePort;
import com.ronrook.StockManager.application.ports.in.DTO.ProductResponse;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.application.ports.out.IProductRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService implements IProductServicePort {

    private final IProductRepositoryPort productRepositoryPort;
    private final ProductMapper productMapper;


    public ProductService(IProductRepositoryPort productRepositoryPort,
                          ProductMapper productMapper) {
        this.productRepositoryPort = productRepositoryPort;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse addProduct(ProductRequest request) {
        var productToCreate = productMapper.toDomain(request);

        var productCreated =   productRepositoryPort.createProduct(productToCreate);

        return  productMapper.toDto(productCreated);
    }

    @Override
    public ProductResponse getProduct(String id) {
        var product = productRepositoryPort.findById(id);

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponse> listProducts() {

        var products = productRepositoryPort.findAll();

        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public boolean removeProduct(String id) {
        return productRepositoryPort.deleteById(id);
    }

    @Override
    public void updateProductQuantity(String id, Integer quantity) {
        Product product = productRepositoryPort.findById(id);
        if (product != null) {
            product.setStandardQuantity(quantity);
            productRepositoryPort.createProduct(product);
        }
    }
}
