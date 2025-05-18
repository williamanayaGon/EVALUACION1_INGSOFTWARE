package com.infrastructure.mapper;

import com.domain.model.Type;
import com.infrastructure.entity.TipoEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TipoEntityMapper {
    Type toModel(TipoEntity entity);
    TipoEntity toEntity(Type model);
}
