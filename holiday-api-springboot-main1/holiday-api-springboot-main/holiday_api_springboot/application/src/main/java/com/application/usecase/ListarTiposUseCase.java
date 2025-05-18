package com.application.usecase;

import com.application.mapper.TypeMapper;
import com.domain.model.Type;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTiposUseCase {
    private final TipoService tipoService;

    public ListarTiposUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    public List<Type> ejecutar() {
        return tipoService.findAll();
    }
}
