package com.application.usecase;

import com.application.dto.HolidayDateDTO;
import com.application.mapper.HolidayDateMapper;
import com.domain.model.HolidayDate;
import com.domain.service.FestivoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarFestivosUseCase {
    private final FestivoService festivoService;
    private final HolidayDateMapper mapper;

    public ListarFestivosUseCase(FestivoService festivoService, HolidayDateMapper mapper) {
        this.festivoService = festivoService;
        this.mapper = mapper;
    }

    public List<HolidayDateDTO> ejecutar(int anio, Long idPais) {
        List<HolidayDate> festivosDelDominio = festivoService.listarFestivosPorPaisYAño(anio, idPais);
        return mapper.toDtoList(festivosDelDominio);
    }
}
