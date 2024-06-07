package com.ronrook.StockManager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private String id;
    private String name;
    private String contact;
    private String address;
}
