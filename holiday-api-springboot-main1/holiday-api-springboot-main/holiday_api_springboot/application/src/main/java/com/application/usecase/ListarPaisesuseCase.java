package com.application.usecase;

import com.application.dto.CountryDTO;
import com.application.mapper.CountryMapper;
import com.application.service.CountryServiceImpl;
import com.domain.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPaisesuseCase {
    private final CountryServiceImpl paisService;
    private  final CountryMapper mapper;

    public ListarPaisesuseCase(CountryServiceImpl paisService, CountryMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public List<CountryDTO> ejecutar() {
        List<Country> paises = paisService.findAll();
        return paises.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


}
