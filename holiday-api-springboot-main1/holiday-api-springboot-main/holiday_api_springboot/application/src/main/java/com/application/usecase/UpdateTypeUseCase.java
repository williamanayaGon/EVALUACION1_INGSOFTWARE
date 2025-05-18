package com.application.usecase;

import com.application.dto.UpdateTiypeDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.TypeMapper;
import com.domain.model.Type;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class UpdateTypeUseCase {
    private final TipoService tipoService;
    private final TypeMapper mapper;

    public UpdateTypeUseCase(TipoService tipoService, TypeMapper mapper) {
        this.tipoService = tipoService;
        this.mapper = mapper;
    }

    public Type ejecutar(UpdateTiypeDTO updateTipoDTO) {
        Type tipo = tipoService.findById(updateTipoDTO.getId())
                .orElseThrow(() -> new NotFoundException("No se encontró el tipo con id: " + updateTipoDTO.getId()));



        tipo.setTipo(updateTipoDTO.getTipo());
        return  tipoService.save(tipo);
    }
}
