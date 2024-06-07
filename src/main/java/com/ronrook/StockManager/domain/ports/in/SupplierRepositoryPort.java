package com.ronrook.StockManager.domain.ports.in;

import com.ronrook.StockManager.domain.model.Supplier;

import java.util.List;

public interface SupplierRepositoryPort {
    Supplier save(Supplier supplier);
    Supplier findById(String id);
    List<Supplier> findAll();
    void deleteById(String id);
}
