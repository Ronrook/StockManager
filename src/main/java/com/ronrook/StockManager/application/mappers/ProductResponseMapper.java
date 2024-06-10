package com.ronrook.StockManager.application.mappers;

import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;
import com.ronrook.StockManager.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "additionalFields", target = "additionalFields")
    ProductResponseDTO toDto(Product domain);
}
