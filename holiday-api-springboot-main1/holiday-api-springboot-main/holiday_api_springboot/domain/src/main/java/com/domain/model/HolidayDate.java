package com.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class HolidayDate {
    @Getter @Setter
    private LocalDate fecha;
    @Getter @Setter
    private String nombre;

    public HolidayDate(LocalDate fecha, String nombre) {
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
