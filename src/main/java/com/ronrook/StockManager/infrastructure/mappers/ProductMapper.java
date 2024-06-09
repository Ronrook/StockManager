package com.ronrook.StockManager.infrastructure.mappers;


import com.ronrook.StockManager.domain.model.Product;
import com.ronrook.StockManager.infrastructure.entities.ProductMongoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

        @Mappings({
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "name", target = "name"),
                @Mapping(source = "quantity", target = "quantity"),
                @Mapping(source = "description", target = "description"),
                @Mapping(source = "additionalFields", target = "additionalFields")
        })
        Product entityToDomain(ProductMongoEntity entity);

        @InheritInverseConfiguration
        @Mapping(target = "additionalFields", ignore = true) // Ignorar el campo adicionalFields si no está presente
        ProductMongoEntity domainToEntity(Product domain);

        // Método para manejar manualmente la conversión inversa
        default ProductMongoEntity domainToEntityWithAdditionalFields(Product domain) {
                ProductMongoEntity entity = new ProductMongoEntity();
                entity.setId(domain.getId());
                entity.setName(domain.getName());
                entity.setQuantity(domain.getQuantity());
                entity.setDescription(domain.getDescription());
                if (domain.getAdditionalFields() != null && !domain.getAdditionalFields().isEmpty()) {
                        entity.setAdditionalFields(domain.getAdditionalFields());
                }
                return entity;
        }
}

