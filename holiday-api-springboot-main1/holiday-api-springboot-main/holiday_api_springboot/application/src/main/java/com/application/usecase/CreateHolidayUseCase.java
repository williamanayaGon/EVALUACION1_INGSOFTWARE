package com.application.usecase;

import com.application.dto.CreateHolidaysDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.HolidayMapper;
import com.domain.model.Holiday;
import com.domain.model.Country;
import com.domain.model.Type;
import com.domain.service.FestivoService;
import com.domain.service.PaisService;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class CreateHolidayUseCase {
    private final FestivoService festivoService;
    private final TipoService tipoService;
    private final PaisService paisService;
    private final HolidayMapper festivoMapper;

    public CreateHolidayUseCase(FestivoService festivoService, TipoService tipoService, PaisService paisService,
            HolidayMapper festivoMapper) {
        this.festivoService = festivoService;
        this.tipoService = tipoService;
        this.paisService = paisService;
        this.festivoMapper = festivoMapper;
    }

    public Holiday ejecutar(CreateHolidaysDTO createFestivoDTO) {
        // validate if tipo and pais exists
        Type tipo = tipoService.findById(createFestivoDTO.getTipoId())
                .orElseThrow(() -> new NotFoundException("Tipo not found with id: " + createFestivoDTO.getTipoId()));

        Country pais = paisService.findById(createFestivoDTO.getPaisId())
                .orElseThrow(() -> new NotFoundException("Pais not found with id: " + createFestivoDTO.getPaisId()));

        Holiday festivo = festivoMapper.toModel(createFestivoDTO);
       
        festivo.setPais(pais);
        festivo.setTipo(tipo);

        return festivoService.save(festivo);
    }
}
