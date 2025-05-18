package com.application.service;

import com.domain.model.Holiday;
import com.domain.model.HolidayDate;
import com.domain.repository.FestivoRepository;
import com.domain.service.FestivoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class HolidayServiceImpl implements FestivoService {
    private final FestivoRepository festivoRepository;

    public HolidayServiceImpl(FestivoRepository festivoRepository) {
        this.festivoRepository = festivoRepository;

    }

    @Override
    public Optional<Holiday> esFestivo(int anio, int mes, int dia, Long idPais) {

        List<Holiday> festivosPais = festivoRepository.findByPais(idPais);

        LocalDate fechaConsulta = LocalDate.of(anio, mes, dia);

        LocalDate domingoPascua = calcularDomingoPascua(anio);

        for (Holiday festivo : festivosPais) {
            Long idTipo = festivo.getIdTipo();

            if (idTipo == 1L) {
                if (festivo.getMes() == mes && festivo.getDia() == dia) {
                    return Optional.of(festivo);
                }
            } else if (idTipo == 2L) {
                LocalDate fechaFestivo = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                LocalDate fechaLunes = trasladarAlSiguienteLunes(fechaFestivo);

                if (fechaLunes.equals(fechaConsulta)) {
                    return Optional.of(festivo);
                }
            } else if (idTipo == 3L) {
                if (festivo.getDiasPascua() != null) {
                    LocalDate fechaFestivo = domingoPascua.plusDays(festivo.getDiasPascua());

                    if (fechaFestivo.equals(fechaConsulta)) {
                        return Optional.of(festivo);
                    }
                }
            } else if (idTipo == 4L) {
                if (festivo.getDiasPascua() != null) {
                    LocalDate fechaFestivo = domingoPascua.plusDays(festivo.getDiasPascua());
                    LocalDate fechaLunes = trasladarAlSiguienteLunes(fechaFestivo);

                    if (fechaLunes.equals(fechaConsulta)) {
                        return Optional.of(festivo);
                    }
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<HolidayDate> listarFestivosPorPaisYAño(int anio, Long idPais) {
        List<HolidayDate> listaFestivos = new ArrayList<HolidayDate>();

        List<Holiday> festivosPais = festivoRepository.findByPais(idPais);

        LocalDate domingoPascua = calcularDomingoPascua(anio);

        for (Holiday festivo : festivosPais) {
            LocalDate fecha = null;
            if (festivo.getIdTipo() == 1L) {
                fecha = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                listaFestivos.add(new HolidayDate(fecha, festivo.getNombre()));

            } else if (festivo.getIdTipo() == 2L) {
                LocalDate fechaFestivo = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                fecha = trasladarAlSiguienteLunes(fechaFestivo);
                listaFestivos.add(new HolidayDate(fecha, festivo.getNombre()));

            } else if (festivo.getIdTipo() == 3L) {
                if (festivo.getDiasPascua() != null) {
                    fecha = domingoPascua.plusDays(festivo.getDiasPascua());
                    listaFestivos.add(new HolidayDate(fecha, festivo.getNombre()));
                }

            } else if (festivo.getIdTipo() == 4L) {
                if (festivo.getDiasPascua() != null) {
                    LocalDate fechaFestivo = domingoPascua.plusDays(festivo.getDiasPascua());
                    fecha = trasladarAlSiguienteLunes(fechaFestivo);
                    listaFestivos.add(new HolidayDate(fecha, festivo.getNombre()));
                }
            }
        }

        return listaFestivos;
    }

    @Override
    public Optional<Holiday> findById(Long id) {
        return festivoRepository.findById(id);
    }

    @Override
    public List<Holiday> findAll() {
        return festivoRepository.findAll();
    }

    @Override
    public Holiday save(Holiday festivo) {
        return festivoRepository.save(festivo);
    }

    @Override
    public void deleteById(Long id) {
        festivoRepository.deleteById(id);
    }

    private LocalDate trasladarAlSiguienteLunes(LocalDate fecha) {
        if (fecha.getDayOfWeek() == DayOfWeek.MONDAY) {
            return fecha;
        }

        int diasHastaLunes = DayOfWeek.MONDAY.getValue() - fecha.getDayOfWeek().getValue();
        if (diasHastaLunes <= 0) {
            diasHastaLunes += 7;
        }

        return fecha.plusDays(diasHastaLunes);
    }

    private LocalDate calcularDomingoPascua(int anio) {
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        LocalDate domingoRamos = LocalDate.of(anio, 3, 15).plusDays(dias);

        return domingoRamos.plusDays(7);
    }
}
