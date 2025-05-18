package com.domain.repository;

import com.domain.model.Holiday;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository {


    List<Holiday> findByPais(Long idPais);

    Optional<Holiday> findById(Long id);

    List<Holiday> findAll();

    Holiday save(Holiday festivo);

    void deleteById(Long id);
    
}
