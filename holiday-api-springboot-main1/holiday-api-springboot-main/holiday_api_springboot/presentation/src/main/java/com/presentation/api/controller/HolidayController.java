package com.presentation.api.controller;

import com.application.dto.CreateHolidaysDTO;
import com.application.dto.HolidayDateDTO;
import com.application.dto.UpdateHolidayDto;
import com.application.usecase.*;
import com.domain.model.Holiday;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/festivos")
public class HolidayController {
    private final static Logger logger = LoggerFactory.getLogger(HolidayController.class);

    private final VerificationHolidayUseCase verificarFestivoUseCase;
    private final ListarFestivosUseCase listarFestivosUseCase;
    private final CreateHolidayUseCase createFestivoUseCase;
    private final UpdateHolidayUseCase actualizarFestivoUseCase;
    private final DeleteHolidayUseCase eliminarFestivoUseCase;
    private final ObtainHolidayUseCase obtenerFestivoIdUseCase;

    public HolidayController(VerificationHolidayUseCase verificarFestivoUseCase,
                             ListarFestivosUseCase listarFestivosUseCase, CreateHolidayUseCase createFestivoUseCase, UpdateHolidayUseCase actualizarFestivoUseCase, DeleteHolidayUseCase eliminarFestivoUseCase, ObtainHolidayUseCase obtenerFestivoIdUseCase) {
        this.verificarFestivoUseCase = verificarFestivoUseCase;
        this.listarFestivosUseCase = listarFestivosUseCase;
        this.createFestivoUseCase = createFestivoUseCase;
        this.actualizarFestivoUseCase = actualizarFestivoUseCase;
        this.eliminarFestivoUseCase = eliminarFestivoUseCase;
        this.obtenerFestivoIdUseCase = obtenerFestivoIdUseCase;
    }

    @GetMapping("/{pais}/{anio}")
    public ResponseEntity<List<HolidayDateDTO>> listaFestivcs(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio) {
        List<HolidayDateDTO> lista = listarFestivosUseCase.ejecutar(anio, idPais);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{pais}/{anio}/{mes}/{dia}")
    public ResponseEntity<String> validarFestivo(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {

        // Validación de fecha básica
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return ResponseEntity.badRequest().body("Fecha No Válida");
        }

        return verificarFestivoUseCase.ejecutar(anio, mes, dia, idPais)
                ? ResponseEntity.ok("Es festivo")
                : ResponseEntity.ok("No es festivo");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> obtenerFestivo(@PathVariable Long id) {
        return ResponseEntity.ok(obtenerFestivoIdUseCase.ejecutar(id));
    }

    @PostMapping()
    public ResponseEntity<Holiday> crearFestivo(@Valid  @RequestBody CreateHolidaysDTO festivoDTO) {
        Holiday festivo = createFestivoUseCase.ejecutar(festivoDTO);
        return ResponseEntity.status(201).body(festivo);
    }

    @PatchMapping()
    public ResponseEntity<Holiday> actualizarFestivo(@Valid @RequestBody UpdateHolidayDto festivo) {
        return ResponseEntity.status(200).body(actualizarFestivoUseCase.ejecutar(festivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFestivo(@PathVariable Long id) {
        eliminarFestivoUseCase.ejecutar(id);
        return ResponseEntity.status(200).body("Festivo with ID " + id + " deleted successfully");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            logger.warn("Validation error for field '{}': {}", fieldName, errorMessage);
        });
        return errors;
    }
}
