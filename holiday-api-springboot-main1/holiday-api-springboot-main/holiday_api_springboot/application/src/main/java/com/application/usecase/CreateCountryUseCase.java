package com.application.usecase;

import com.application.dto.CreateCountryDTO;
import com.application.mapper.CountryMapper;
import com.domain.model.Country;
import com.domain.service.PaisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateCountryUseCase {
    private static final Logger logger = LoggerFactory.getLogger(CreateCountryUseCase.class); // Add logger
    private final PaisService paisService;
    private final CountryMapper mapper;

    public CreateCountryUseCase(PaisService paisService, CountryMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public Country ejecutar(CreateCountryDTO createPaisDTO) {
        logger.info("CreatePaisDTO received with nombre: {}", createPaisDTO.getNombre());
        Country pais = mapper.toEntity(createPaisDTO);
        // Assuming Pais has getNombre() and getId()
        logger.info("Pais object after mapping from DTO: id={}, nombre={}", pais.getId(), pais.getNombre());
        Country savedPais = paisService.save(pais);
        logger.info("Pais object after save service call: id={}, nombre={}", savedPais.getId(), savedPais.getNombre());
        return savedPais;
    }

}
