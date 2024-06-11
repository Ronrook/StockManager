package com.ronrook.StockManager.application.mappers;

import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;
import com.ronrook.StockManager.application.ports.out.ProductResponseWithAdditionalFields;
import com.ronrook.StockManager.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public record ProductResponseMapper(@Autowired ModelMapper modelMapper) {

    public ProductResponseDTO toDto(Product domain) {

        ProductResponseDTO productResponse = modelMapper.map(domain, ProductResponseDTO.class);

        if (domain.getAdditionalFields() != null && !domain.getAdditionalFields().isEmpty()) {
            return modelMapper.map(
                    domain, ProductResponseWithAdditionalFields.class);
        }
        return productResponse;
    }
}



