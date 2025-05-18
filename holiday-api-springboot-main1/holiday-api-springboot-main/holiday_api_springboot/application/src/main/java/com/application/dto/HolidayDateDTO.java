package com.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class HolidayDateDTO {
    @Getter @Setter
    private LocalDate fecha;

    @Getter
    @Setter
    private String nombre;

    public HolidayDateDTO(LocalDate fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
