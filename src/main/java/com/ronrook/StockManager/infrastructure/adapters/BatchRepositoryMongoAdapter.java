package com.ronrook.StockManager.infrastructure.adapters;

import com.ronrook.StockManager.application.ports.out.BatchRepositoryPort;
import com.ronrook.StockManager.application.ports.out.IProductRepositoryPort;
import com.ronrook.StockManager.domain.model.Batch;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.infrastructure.entities.BatchMongoEntity;
import com.ronrook.StockManager.infrastructure.mappers.IBatchMapper;
import com.ronrook.StockManager.infrastructure.repositories.IMongoBatchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BatchRepositoryMongoAdapter implements BatchRepositoryPort {


    private final IMongoBatchRepository mongoBatchRepository;
    private final IBatchMapper batchMapper;
    private final IProductRepositoryPort productRepository;

    public BatchRepositoryMongoAdapter(IMongoBatchRepository mongoBatchRepository,
                                       IBatchMapper batchMapper,
                                       IProductRepositoryPort productRepository) {
        this.mongoBatchRepository = mongoBatchRepository;
        this.batchMapper = batchMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Batch save(Batch batch) {
        Product product = productRepository.findById(batch.getProduct().getId());
        batch.setProduct(product);
        BatchMongoEntity entity = batchMapper.domainToEntity(batch);
        BatchMongoEntity savedEntity = mongoBatchRepository.save(entity);
        return batchMapper.entityToDomain(savedEntity);
    }

    @Override
    public Batch findById(String id) {
        return mongoBatchRepository.findById(id)
                .map(batch -> {
                    Batch domainBatch = batchMapper.entityToDomain(batch);
                    Product product = productRepository.findById(domainBatch.getProduct().getId());
                    domainBatch.setProduct(product);
                    return domainBatch;
                })
                .orElse(null);
    }

    @Override
    public List<Batch> findAll() {
        return mongoBatchRepository.findAll()
                .stream()
                .map(batchMapper::entityToDomain)
                .toList();
    }

    @Override
    public boolean deleteById(String id) {
        if (mongoBatchRepository.existsById(id)) {
            mongoBatchRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Batch updateQuantity(String id, int quantity) {
        Optional<BatchMongoEntity> optionalEntity = mongoBatchRepository.findById(id);
        if (optionalEntity.isPresent()) {
            BatchMongoEntity entity = optionalEntity.get();
            entity.setCurrentQuantity(quantity);
            mongoBatchRepository.save(entity);
            return batchMapper.entityToDomain(entity);
        }
        return null;
    }
}