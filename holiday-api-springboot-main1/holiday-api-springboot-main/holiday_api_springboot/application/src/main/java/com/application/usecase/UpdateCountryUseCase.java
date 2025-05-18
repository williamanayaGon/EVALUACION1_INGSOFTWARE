package com.application.usecase;

import com.application.dto.CountryDTO;
import com.application.dto.UpdateCountryDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.CountryMapper;
import com.application.service.CountryServiceImpl;
import com.domain.model.Country;
import org.springframework.stereotype.Component;

@Component
public class UpdateCountryUseCase {
    private final CountryServiceImpl paisService;
    private final CountryMapper mapper;

    public UpdateCountryUseCase(CountryServiceImpl paisService, CountryMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public CountryDTO ejecutar(UpdateCountryDTO updatePaisDTO) {
        Country pais = paisService.findById(updatePaisDTO.getId())
                .orElseThrow(() -> new NotFoundException("No se encontró el país con id: " + updatePaisDTO.getId()));

        pais.setNombre(updatePaisDTO.getNombre());
        return mapper.toDto(paisService.save(pais));
    }
}
