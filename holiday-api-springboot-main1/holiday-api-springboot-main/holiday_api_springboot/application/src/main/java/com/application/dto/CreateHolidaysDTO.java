package com.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateHolidaysDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotNull(message = "El día no puede ser nulo")
    @Min(value = 1, message = "El día debe ser como mínimo 1")
    @Max(value = 31, message = "El día debe ser como máximo 31")
    private Byte dia;

    @NotNull(message = "El mes no puede ser nulo")
    @Min(value = 1, message = "El mes debe ser como mínimo 1")
    @Max(value = 12, message = "El mes debe ser como máximo 12")
    private Byte mes;

    @NotNull
    private Short diasPascua;

    @NotNull(message = "El ID del país no puede ser nulo")
    private Long paisId;

    @NotNull(message = "El ID del tipo no puede ser nulo")
    private Long tipoId;

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
