package com.application.usecase;

import com.application.dto.UpdateHolidayDto;
import com.application.exception.NotFoundException;
import com.domain.model.Holiday;
import com.domain.model.Country;
import com.domain.model.Type;
import com.domain.service.FestivoService;
import com.domain.service.PaisService;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class UpdateHolidayUseCase {

    private final FestivoService festivoService;
    private final TipoService tipoService;
    private final PaisService paisService;

    public UpdateHolidayUseCase(FestivoService festivoService, TipoService tipoService, PaisService paisService) {
        this.festivoService = festivoService;
        this.tipoService = tipoService;
        this.paisService = paisService;
    }

    public Holiday ejecutar(UpdateHolidayDto updateFestivoDto) {
        Holiday festivo = festivoService.findById(updateFestivoDto.getId())
                .orElseThrow(
                        () -> new NotFoundException("No se encontró el festivo con id: " + updateFestivoDto.getId()));

        if (updateFestivoDto.getNombre() != null) {
            festivo.setNombre(updateFestivoDto.getNombre());
        }
        if (updateFestivoDto.getDia() != null) {
            festivo.setDia(updateFestivoDto.getDia());
        }
        if (updateFestivoDto.getMes() != null) {
            festivo.setMes(updateFestivoDto.getMes());
        }

        if (updateFestivoDto.getDiasPascua() != null) {
            festivo.setDiasPascua(updateFestivoDto.getDiasPascua());
        }

        if (updateFestivoDto.getTipoId() != null) {
            Type tipo = tipoService.findById(updateFestivoDto.getTipoId())
                    .orElseThrow(
                            () -> new NotFoundException("Tipo not found with id: " + updateFestivoDto.getTipoId()));
            festivo.setTipo(tipo);
        }

        if (updateFestivoDto.getPaisId() != null) {
            Country pais = paisService.findById(updateFestivoDto.getPaisId())
                    .orElseThrow(
                            () -> new NotFoundException("Pais not found with id: " + updateFestivoDto.getPaisId()));
            festivo.setPais(pais);
        }

        return festivoService.save(festivo);
    }
}
