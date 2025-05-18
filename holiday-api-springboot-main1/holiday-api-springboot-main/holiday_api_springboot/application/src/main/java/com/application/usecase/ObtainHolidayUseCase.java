package com.application.usecase;

import com.domain.model.Holiday;
import com.domain.service.FestivoService;
import org.springframework.stereotype.Component;

@Component
public class ObtainHolidayUseCase {
    private final FestivoService festivoService;

    public ObtainHolidayUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    public Holiday ejecutar(Long id) {
        return festivoService.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el festivo con id: " + id));
    }
}
