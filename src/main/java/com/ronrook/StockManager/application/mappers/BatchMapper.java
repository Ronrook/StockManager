package com.ronrook.StockManager.application.mappers;

import com.ronrook.StockManager.application.ports.in.DTO.*;
import com.ronrook.StockManager.domain.model.Batch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public record BatchMapper(@Autowired ModelMapper modelMapper){

    public Batch toDomain(BatchRequest request) {
        return modelMapper.map(request, Batch.class);
    }

    public BatchResponse toDto(Batch domain) {

        BatchResponse productResponse = modelMapper.map(domain, BatchResponse.class);

        if (domain.getAdditionalFields() != null && !domain.getAdditionalFields().isEmpty()) {
            return modelMapper.map(
                    domain, BatchResponseWithAdditionalFields.class);
        }
        return productResponse;
    }
}
