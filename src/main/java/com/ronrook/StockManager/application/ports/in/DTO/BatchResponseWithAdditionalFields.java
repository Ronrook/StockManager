package com.ronrook.StockManager.application.ports.in.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponseWithAdditionalFields extends BatchResponse{
    private Map<String, Object> additionalFields;
}
