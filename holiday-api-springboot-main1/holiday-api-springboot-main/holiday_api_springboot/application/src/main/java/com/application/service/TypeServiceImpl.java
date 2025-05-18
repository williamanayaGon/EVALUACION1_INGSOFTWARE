package com.application.service;

import com.domain.model.Type;
import com.domain.repository.TipoRepository;
import com.domain.service.TipoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TipoService {
    private  final TipoRepository tipoRepository;

    public TypeServiceImpl(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public Optional<Type> findById(Long id) {
        return  tipoRepository.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return tipoRepository.findAll();
    }

    @Override
    public Type save(Type tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }
}
