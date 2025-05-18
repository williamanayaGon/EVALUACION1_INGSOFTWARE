package com.infrastructure.persistence;

import com.domain.model.Country;
import com.domain.repository.PaisRepository;
import com.infrastructure.entity.PaisEntity;
import com.infrastructure.mapper.PaisEntityMapper;
import com.infrastructure.persistence.jpa.JpaPaisRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaisRepositoryImpl implements PaisRepository {
    private final  JpaPaisRepository jpaPaisRepository;
    private final PaisEntityMapper mapper;

    public PaisRepositoryImpl(JpaPaisRepository jpaPaisRepository, PaisEntityMapper mapper) {
        this.jpaPaisRepository = jpaPaisRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Country> findById(Long id) {
        Optional<PaisEntity> entityOptional = jpaPaisRepository.findById(id);
        return entityOptional.map(mapper::toModel);
    }

    @Override
    public List<Country> findAll() {
        List<PaisEntity> entityList = jpaPaisRepository.findAll();
        return entityList.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Country save(Country pais) {
        PaisEntity entity = mapper.toEntity(pais);
        PaisEntity savedEntity = jpaPaisRepository.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaPaisRepository.deleteById(id);
    }
}
