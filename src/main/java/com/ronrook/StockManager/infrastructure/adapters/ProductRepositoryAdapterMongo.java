package com.ronrook.StockManager.infrastructure.adapters;

import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.application.ports.out.IProductRepositoryPort;
import com.ronrook.StockManager.infrastructure.repositories.MongoProductRepository;
import com.ronrook.StockManager.infrastructure.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapterMongo implements IProductRepositoryPort {

    @Autowired
    private MongoProductRepository mongoProductRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public Product createProduct(Product product) {
        var entity = this.productMapper.domainToEntity (product);
        var savedEntity = mongoProductRepository.save(entity);
        return this.productMapper.entityToDomain(savedEntity);
    }

    @Override
    public Product findById(String id) {
        return mongoProductRepository.findById(id)
                .map(this.productMapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return mongoProductRepository.findAll()
                .stream()
                .map(this.productMapper::entityToDomain)
                .toList();
    }

    @Override
    public boolean deleteById(String id) {
        if (mongoProductRepository.existsById(id)) {
            mongoProductRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Product> updateProductQuantity(String id, int quantity) {
        return Optional.empty();
    }

}