package com.domain.repository;

import com.domain.model.Type;

import java.util.List;
import java.util.Optional;

public interface TipoRepository {

    Optional<Type> findById(Long id);

    List<Type> findAll();

    Type save(Type tipo);

    void deleteById(Long id);
}
