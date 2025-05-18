package com.application.usecase;

import com.application.exception.NotFoundException;
import com.domain.model.Holiday;
import com.domain.model.Type;
import com.domain.service.FestivoService;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class DeleteHolidayUseCase {
    private final FestivoService festivoService;

    public DeleteHolidayUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;

    }

    public void ejecutar(Long id) {
        Holiday festivo = festivoService.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el festivo con id: " + id));
        festivoService.deleteById(id);

    }
}
