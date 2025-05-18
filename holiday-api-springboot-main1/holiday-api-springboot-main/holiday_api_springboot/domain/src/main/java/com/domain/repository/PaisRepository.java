package com.domain.repository;

import com.domain.model.Country;

import java.util.List;
import java.util.Optional;

public interface PaisRepository {

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country save(Country pais);

    void deleteById(Long id);
}
