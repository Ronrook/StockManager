package com.ronrook.StockManager.infrastructure.mappers;

import com.ronrook.StockManager.domain.model.Batch;
import com.ronrook.StockManager.infrastructure.entities.BatchMongoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBatchMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "batchDate", target = "batchDate")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "initialQuantity", target = "initialQuantity")
    @Mapping(source = "currentQuantity", target = "currentQuantity")
    @Mapping(source = "location", target = "location")
    @Mapping(source = "additionalFields", target = "additionalFields")
    BatchMongoEntity domainToEntity(Batch domain);

    @InheritInverseConfiguration
    Batch entityToDomain(BatchMongoEntity entity);
}
