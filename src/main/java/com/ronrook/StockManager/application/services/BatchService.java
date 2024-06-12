package com.ronrook.StockManager.application.services;

import com.ronrook.StockManager.application.mappers.BatchMapper;
import com.ronrook.StockManager.application.ports.in.DTO.BatchRequest;
import com.ronrook.StockManager.application.ports.in.DTO.BatchResponse;
import com.ronrook.StockManager.application.ports.in.IBatchServicePort;
import com.ronrook.StockManager.application.ports.out.IBatchRepositoryPort;
import com.ronrook.StockManager.application.ports.out.INotificationServicePort;
import com.ronrook.StockManager.domain.model.Batch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService implements IBatchServicePort{

    private final IBatchRepositoryPort batchRepositoryPort;
    private final INotificationServicePort notificationService;
    private final BatchMapper batchMapper;

    public BatchService(IBatchRepositoryPort batchRepositoryPort,
                        INotificationServicePort notificationService,
                        BatchMapper batchMapper) {
        this.batchRepositoryPort = batchRepositoryPort;
        this.notificationService = notificationService;
        this.batchMapper = batchMapper;
    }

    @Override
    public BatchResponse addBatch(BatchRequest request) {
        var batchToCreate = batchMapper.toDomain(request);
        var batchCreated = batchRepositoryPort.save(batchToCreate);
        return  batchMapper.toDto(batchCreated);
    }

    @Override
    public BatchResponse getBatch(String id) {
        var batch = batchRepositoryPort.findById(id);
        return batchMapper.toDto(batch);
    }

    @Override
    public List<BatchResponse> listBatches() {
        var batches = batchRepositoryPort.findAll();

        return batches
                .stream()
                .map(batchMapper::toDto)
                .toList();
    }

    @Override
    public boolean removeBatch(String id) {
        return batchRepositoryPort.deleteById(id);
    }

    @Override
    public void updateBatchQuantity(String id, int quantity) {
        Batch batch = batchRepositoryPort.findById(id);
        if (batch != null) {
            batch.setCurrentQuantity(quantity);
            batchRepositoryPort.save(batch);
            if (batch.getCurrentQuantity() == 5) {
                notificationService.sendNotification("Batch with ID " + id + " has a current quantity of 10.");
            }
        }
    }
}
