package com.application.usecase;

import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class DeleteTypeUseCase {
    private final TipoService tipoService;
    public DeleteTypeUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    public void ejecutar(Long id) {
        tipoService.findById(id).ifPresentOrElse(
                tipo -> tipoService.deleteById(id),
                () -> {
                    throw new RuntimeException("No se encontró el tipo con id: " + id);
                }
        );
    }
}
