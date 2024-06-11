package com.ronrook.StockManager.application.ports.in.DTO;


import com.ronrook.StockManager.application.ports.in.DTO.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseWithAdditionalFields extends ProductResponse {
    private Map<String, Object> additionalFields;
}