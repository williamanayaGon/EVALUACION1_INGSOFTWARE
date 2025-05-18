package com.presentation.api.controller;

import com.application.dto.CreateTypeDTO;
import com.application.dto.UpdateTiypeDTO;
import com.application.usecase.*;
import com.domain.model.Type;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo")
public class TypeController {
    private static final Logger logger = LoggerFactory.getLogger(TypeController.class);

    private final CreateTipoUseCase createTipoUseCase;
    private final ListarTiposUseCase listarTiposUseCase;
    private final ObtainTipoIdUseCase obtenerTipoIdUseCase;
    private final UpdateTypeUseCase actualizarTipoUseCase;
    private final DeleteTypeUseCase eliminarTipoUseCase;

    public TypeController(CreateTipoUseCase createTipoUseCase, ListarTiposUseCase listarTiposUseCase, ObtainTipoIdUseCase obtenerTipoIdUseCase, UpdateTypeUseCase actualizarTipoUseCase, DeleteTypeUseCase eliminarTipoUseCase) {
        this.createTipoUseCase = createTipoUseCase;
        this.listarTiposUseCase = listarTiposUseCase;
        this.obtenerTipoIdUseCase = obtenerTipoIdUseCase;
        this.actualizarTipoUseCase = actualizarTipoUseCase;
        this.eliminarTipoUseCase = eliminarTipoUseCase;
    }

    @PostMapping()
    public ResponseEntity<Type> crearTipo(@Valid @RequestBody CreateTypeDTO tipoDTO) {
        logger.info("Attempting to create Tipo with name: {}", tipoDTO.getTipo());
        Type tipoModel = createTipoUseCase.ejecutar(tipoDTO);
        logger.info("Successfully created Tipo with ID: {} and name: {}", tipoModel.getId(), tipoModel.getTipo());
        return ResponseEntity.status(201).body(tipoModel);
    }

    @GetMapping()
    public ResponseEntity<List<Type>> listarTipos() {
        return ResponseEntity.status(200).body(listarTiposUseCase.ejecutar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Type>> obtenerTipo(@PathVariable Long id) {
        return ResponseEntity.status(200).body(obtenerTipoIdUseCase.ejecutar(id));
    }

    @PatchMapping()
    public ResponseEntity<Type> actualizarTipo(@Valid @RequestBody UpdateTiypeDTO tipoDTO) {
        // Implementar la lógica de actualización aquí
        return ResponseEntity.status(200).body(actualizarTipoUseCase.ejecutar(tipoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipo(@PathVariable Long id) {
        eliminarTipoUseCase.ejecutar(id);
        return ResponseEntity.status(200).body("Tipo with ID " + id + " deleted successfully");
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
