package com.domain.service;

import com.domain.model.Type;

import java.util.List;
import java.util.Optional;

public interface TipoService {
    Optional<Type> findById(Long id);

    List<Type> findAll();

    Type save(Type tipo);

    void deleteById(Long id);
}
