package com.application.usecase;

import com.domain.service.FestivoService;
import org.springframework.stereotype.Component;

@Component
public class VerificationHolidayUseCase {
    private final FestivoService festivoService;

    public VerificationHolidayUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    public boolean ejecutar(int anio, int mes, int dia, Long idPais) {
        return festivoService.esFestivo(anio, mes, dia, idPais).isPresent();
    }
}
