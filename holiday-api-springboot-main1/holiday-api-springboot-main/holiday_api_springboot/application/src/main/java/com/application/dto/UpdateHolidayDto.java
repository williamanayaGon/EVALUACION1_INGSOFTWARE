package com.application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateHolidayDto {
    @NotNull // El ID es necesario para saber qué festivo actualizar
    private Long id;

    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre; // Opcional

    @Min(value = 1, message = "El día debe ser como mínimo 1")
    @Max(value = 31, message = "El día debe ser como máximo 31")
    private Byte dia; // Opcional

    @Min(value = 1, message = "El mes debe ser como mínimo 1")
    @Max(value = 12, message = "El mes debe ser como máximo 12")
    private Byte mes; // Opcional

    private Short diasPascua; // Opcional

    private Long paisId; // Opcional

    private Long tipoId; // Opcional

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        this.dia = dia;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        this.mes = mes;
    }

    public Short getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(Short diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

}

