package com.application.dto;

import lombok.Getter;
import lombok.Setter;

public class CountryDTO {
    @Getter @Setter
    private  Long id;

    @Getter @Setter
    private  String nombre;

    public CountryDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

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


    
}
