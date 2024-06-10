package com.ronrook.StockManager.application.mappers;


import com.ronrook.StockManager.application.ports.in.DTO.CreateProductDTO;
import com.ronrook.StockManager.domain.model.Product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public record ProductRequestMapper(@Autowired ModelMapper modelMapper) {

    public Product toDomain(CreateProductDTO request) {
        return modelMapper.map(request, Product.class);
    }
}
