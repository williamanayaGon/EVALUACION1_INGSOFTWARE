package com.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {
    private Long id;
    private Country pais;
    private String nombre;
    private Byte dia;
    private Byte mes;
    private Short diasPascua;
    private Type tipo;

    public Long getIdTipo() {
        return tipo.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getPais() {
        return pais;
    }

    public void setPais(Country pais) {
        this.pais = pais;
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

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

}
