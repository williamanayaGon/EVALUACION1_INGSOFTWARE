package com.domain.service;

import com.domain.model.Holiday;
import com.domain.model.HolidayDate;

import java.util.List;
import java.util.Optional;

public interface FestivoService {


    Optional<Holiday> esFestivo(int anio, int mes, int dia, Long idPais);

    List<HolidayDate> listarFestivosPorPaisYAño(int anio, Long idPais);

    Optional<Holiday> findById(Long id);

    List<Holiday> findAll();

    Holiday save(Holiday festivo);

    void deleteById(Long id);

}
