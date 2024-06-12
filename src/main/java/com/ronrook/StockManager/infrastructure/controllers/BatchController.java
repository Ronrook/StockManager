package com.ronrook.StockManager.infrastructure.controllers;

import com.ronrook.StockManager.application.ports.in.DTO.BatchRequest;
import com.ronrook.StockManager.application.ports.in.DTO.BatchResponse;
import com.ronrook.StockManager.application.ports.in.IBatchServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {

    private IBatchServicePort batchService;

    public BatchController(IBatchServicePort batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public BatchResponse addBatch(@RequestBody BatchRequest batch) {
        return batchService.addBatch(batch);
    }

    @GetMapping("/{id}")
    public BatchResponse getBatch(@PathVariable String id) {
        return batchService.getBatch(id);
    }

    @GetMapping
    public List<BatchResponse> listBatches() {
        return batchService.listBatches();
    }

    @DeleteMapping("/{id}")
    public boolean removeBatch(@PathVariable String id) {
        return batchService.removeBatch(id);
    }

    @PutMapping("/{id}/quantity")
    public void updateBatchQuantity(@PathVariable String id, @RequestParam int quantity) {
        batchService.updateBatchQuantity(id, quantity);
    }
}