package com.application.usecase;

import com.application.exception.NotFoundException;
import com.application.mapper.CountryMapper;
import com.application.service.CountryServiceImpl;
import com.domain.model.Country;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteCountryUseCase {
    private final CountryServiceImpl paisService;
    private final CountryMapper mapper;

    public DeleteCountryUseCase(CountryServiceImpl paisService, CountryMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public void ejecutar(Long id) {
        Country pais = paisService.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el país con id: " + id));

        paisService.deleteById(id);

    }
}
