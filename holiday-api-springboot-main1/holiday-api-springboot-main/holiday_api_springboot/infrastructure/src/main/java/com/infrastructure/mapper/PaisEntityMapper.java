package com.infrastructure.mapper;

import com.domain.model.Country;
import com.infrastructure.entity.PaisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisEntityMapper {
    Country toModel(com.infrastructure.entity.PaisEntity entity);
    PaisEntity toEntity(com.domain.model.Country model);
}
