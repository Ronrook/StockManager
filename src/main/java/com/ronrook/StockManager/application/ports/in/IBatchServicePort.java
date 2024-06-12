package com.ronrook.StockManager.application.ports.in;

import com.ronrook.StockManager.application.ports.in.DTO.BatchRequest;
import com.ronrook.StockManager.application.ports.in.DTO.BatchResponse;
import com.ronrook.StockManager.domain.model.Batch;

import java.util.List;

public interface IBatchServicePort {

    BatchResponse addBatch(BatchRequest batch);
    BatchResponse getBatch(String id);
    List<BatchResponse> listBatches();
    boolean removeBatch(String id);
    void updateBatchQuantity(String id, int quantity);
}
