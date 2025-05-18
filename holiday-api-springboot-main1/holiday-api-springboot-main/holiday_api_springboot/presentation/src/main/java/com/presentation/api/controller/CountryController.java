package com.presentation.api.controller;

import com.application.dto.CreateCountryDTO;
import com.application.dto.CountryDTO;
import com.application.dto.UpdateCountryDTO;
import com.application.mapper.CountryMapper;
import com.application.usecase.*;
import com.domain.model.Country;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
    private final CreateCountryUseCase crearPaisUseCase;
    private final ListarPaisesuseCase listarPaisesuseCase;
    private final UpdateCountryUseCase actualizarPaisUseCase;
    private final ObtainCountryUseCase obtenerPaisIdUseCase;
    private final DeleteCountryUseCase eliminarPaisUseCase;
    private final CountryMapper paisMapper;


    public CountryController(CreateCountryUseCase crearPaisUseCase, ListarPaisesuseCase listarPaisesuseCase, UpdateCountryUseCase actualizarPaisUseCase, ObtainCountryUseCase obtenerPaisIdUseCase, DeleteCountryUseCase eliminarPaisUseCase, CountryMapper paisMapper) {
        this.crearPaisUseCase = crearPaisUseCase;
        this.listarPaisesuseCase = listarPaisesuseCase;
        this.actualizarPaisUseCase = actualizarPaisUseCase;
        this.obtenerPaisIdUseCase = obtenerPaisIdUseCase;
        this.eliminarPaisUseCase = eliminarPaisUseCase;
        this.paisMapper = paisMapper;
    }

    @PostMapping()
    public ResponseEntity<CountryDTO> crearPais(@Valid @RequestBody CreateCountryDTO createPaisDTO) {
        logger.info("Attempting to create Pais with name: {}", createPaisDTO.getNombre());
        Country paisModel = crearPaisUseCase.ejecutar(createPaisDTO);
        CountryDTO paisResponseDTO = paisMapper.toDto(paisModel);
        logger.info("Successfully created Pais with ID: {} and name: {}", paisResponseDTO.getId(),
                paisResponseDTO.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(paisResponseDTO);
    }

    @GetMapping()
    public  ResponseEntity<List<CountryDTO>> listarPaises() {
        logger.info("Attempting to list all Paises");
        List<CountryDTO> paises = listarPaisesuseCase.ejecutar();
        logger.info("Successfully retrieved {} Paises", paises.size());
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CountryDTO>> obtenerPaisPorId(@PathVariable Long id) {
        logger.info("Attempting to retrieve Pais with ID: {}", id);
        Optional<CountryDTO> paisResponseDTO = obtenerPaisIdUseCase.ejecutar(id);
        if (paisResponseDTO.isPresent()) {
            logger.info("Successfully retrieved Pais with ID: {} and name: {}", paisResponseDTO.get().getId(),
                    paisResponseDTO.get().getNombre());
            return ResponseEntity.ok(paisResponseDTO);
        } else {
            logger.warn("Pais with ID: {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @PatchMapping()
    public ResponseEntity<CountryDTO> actualizarPais(
            @Valid @RequestBody UpdateCountryDTO updatePaisDTO) {
        logger.info("Attempting to update Pais with ID: {}", updatePaisDTO.getId());
        CountryDTO paisResponseDTO = actualizarPaisUseCase.ejecutar(updatePaisDTO);
        logger.info("Successfully updated Pais with ID: {} and name: {}", paisResponseDTO.getId(),
                paisResponseDTO.getNombre());
        return ResponseEntity.ok(paisResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPais(@PathVariable Long id) {
        logger.info("Attempting to delete Pais with ID: {}", id);
        eliminarPaisUseCase.ejecutar(id);
        logger.info("Successfully deleted Pais with ID: {}", id);
        return ResponseEntity.ok("Pais with ID " + id + " successfully deleted");
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
