package com.ronrook.StockManager.application.ports.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseWithAdditionalFields extends ProductResponseDTO {
    private Map<String, Object> additionalFields;
}