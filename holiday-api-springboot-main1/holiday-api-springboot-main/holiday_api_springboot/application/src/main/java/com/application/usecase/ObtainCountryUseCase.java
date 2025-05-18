package com.application.usecase;

import com.application.dto.CountryDTO;
import com.application.mapper.CountryMapper;
import com.application.service.CountryServiceImpl;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObtainCountryUseCase {
    private final CountryServiceImpl paisService;
    private final CountryMapper mapper;

    public ObtainCountryUseCase(CountryServiceImpl paisService, CountryMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public Optional<CountryDTO> ejecutar(Long id) {
        return paisService.findById(id)
                .map(pais -> {
                    CountryDTO paisDTO = mapper.toDto(pais);
                    return Optional.of(paisDTO);
                })
                .orElse(Optional.empty());
    }
}
