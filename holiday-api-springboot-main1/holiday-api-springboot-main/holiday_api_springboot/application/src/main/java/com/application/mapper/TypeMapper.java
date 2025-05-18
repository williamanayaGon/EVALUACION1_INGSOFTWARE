package com.application.mapper;

import com.application.dto.CreateTypeDTO;
import com.application.dto.UpdateTiypeDTO;
import com.domain.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    Type toModel(CreateTypeDTO createTipoDTO);
    Type toModel(UpdateTiypeDTO updateTipoDTO);
}
