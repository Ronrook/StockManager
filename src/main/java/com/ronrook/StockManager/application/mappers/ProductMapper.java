package com.ronrook.StockManager.application.mappers;

import com.ronrook.StockManager.application.ports.in.DTO.ProductRequest;
import com.ronrook.StockManager.application.ports.in.DTO.ProductResponse;
import com.ronrook.StockManager.application.ports.in.DTO.ProductResponseWithAdditionalFields;
import com.ronrook.StockManager.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public record ProductMapper(@Autowired ModelMapper modelMapper) {

    public Product toDomain(ProductRequest request) {
        return modelMapper.map(request, Product.class);
    }

    public ProductResponse toDto(Product domain) {

        ProductResponse productResponse = modelMapper.map(domain, ProductResponse.class);

        if (domain.getAdditionalFields() != null && !domain.getAdditionalFields().isEmpty()) {
            return modelMapper.map(
                    domain, ProductResponseWithAdditionalFields.class);
        }
        return productResponse;
    }
}



