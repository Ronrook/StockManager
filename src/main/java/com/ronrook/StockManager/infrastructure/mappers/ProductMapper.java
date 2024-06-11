package com.ronrook.StockManager.infrastructure.mappers;


import com.ronrook.StockManager.application.ports.out.ProductResponseDTO;
import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.infrastructure.entities.ProductMongoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {

        @Mapping(source = "id", target = "id")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "price", target = "price")
        @Mapping(source = "description", target = "description")
        @Mapping(source = "standardQuantity", target = "standardQuantity")
        @Mapping(source = "supplierId", target = "supplierId")
        @Mapping(source = "categoryId", target = "categoryId")
        @Mapping(source = "additionalFields", target = "additionalFields")
        ProductMongoEntity domainToEntity(Product domain);

        @InheritInverseConfiguration
        //@Mapping(target = "additionalFields", ignore = true) // Ignorar el campo adicionalFields si no está presente
        Product entityToDomain(ProductMongoEntity entity);


}

