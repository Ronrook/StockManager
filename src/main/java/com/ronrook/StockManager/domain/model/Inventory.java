package com.ronrook.StockManager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private String id;
    private String productId;
    private int quantity;
}
