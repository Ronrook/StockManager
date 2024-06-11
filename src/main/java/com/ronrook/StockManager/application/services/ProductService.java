package com.ronrook.StockManager.application.services;

import com.ronrook.StockManager.application.mappers.ProductRequestMapper;
import com.ronrook.StockManager.application.mappers.ProductResponseMapper;
import com.ronrook.StockManager.application.ports.in.DTO.CreateProductDTO;
import com.ronrook.StockManager.application.ports.in.IProductServicePort;
import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.application.ports.out.IProductRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService implements IProductServicePort {

    private final IProductRepositoryPort productRepositoryPort;
    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;


    public ProductService(IProductRepositoryPort productRepositoryPort,
                          ProductRequestMapper productRequestMapper,
                          ProductResponseMapper productResponseMapper) {
        this.productRepositoryPort = productRepositoryPort;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public ProductResponseDTO addProduct(CreateProductDTO request) {
        var productToCreate = productRequestMapper.toDomain(request);

        var productCreated =   productRepositoryPort.createProduct(productToCreate);

        return  productResponseMapper.toDto(productCreated);
    }

    @Override
    public ProductResponseDTO getProduct(String id) {
        var product = productRepositoryPort.getProduct(id);

        return productResponseMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDTO> listProducts() {

        var products = productRepositoryPort.listProducts();

        return products
                .stream()
                .map(productResponseMapper::toDto)
                .toList();
    }

    @Override
    public boolean removeProduct(String id) {
        return productRepositoryPort.deleteProduct(id);
    }

    @Override
    public void updateProductQuantity(String id, Integer quantity) {
        Product product = productRepositoryPort.getProduct(id);
        if (product != null) {
            product.setStandardQuantity(quantity);
            productRepositoryPort.createProduct(product);
        }
    }
}
