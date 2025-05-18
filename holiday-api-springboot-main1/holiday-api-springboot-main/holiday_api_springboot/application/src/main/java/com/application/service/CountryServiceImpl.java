package com.application.service;

import com.domain.model.Country;
import com.domain.repository.PaisRepository;
import com.domain.service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements PaisService {
    private final PaisRepository paisRepository;

    public CountryServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }


    @Override
    public Optional<Country> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Country save(Country pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}
