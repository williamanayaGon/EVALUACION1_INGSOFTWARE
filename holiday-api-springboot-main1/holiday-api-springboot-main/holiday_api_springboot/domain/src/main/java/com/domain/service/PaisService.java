package com.domain.service;

import com.domain.model.Country;

import java.util.List;
import java.util.Optional;

public interface PaisService {

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country save(Country pais);

    void deleteById(Long id);
}
