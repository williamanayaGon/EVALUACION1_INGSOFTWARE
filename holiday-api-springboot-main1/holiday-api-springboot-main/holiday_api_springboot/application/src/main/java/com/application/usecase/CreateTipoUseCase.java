package com.application.usecase;

import com.application.dto.CreateTypeDTO;
import com.application.mapper.TypeMapper;
import com.domain.model.Type;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class CreateTipoUseCase {
    private final TipoService tipoService;
    private final TypeMapper tipoMapper;

    public CreateTipoUseCase(TipoService tipoService, TypeMapper tipoMapper) {
        this.tipoService = tipoService;
        this.tipoMapper = tipoMapper;
    }

    public Type ejecutar(CreateTypeDTO tipoDTO) {
        Type tipo = tipoMapper.toModel(tipoDTO);
        return tipoService.save(tipo);
    }
}
