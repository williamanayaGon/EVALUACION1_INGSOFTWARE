package com.application.usecase;

import com.domain.model.Type;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObtainTipoIdUseCase {
    private final TipoService tipoService;

    public ObtainTipoIdUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    public Optional<Type> ejecutar(Long id) {
        return tipoService.findById(id);
    }
}
