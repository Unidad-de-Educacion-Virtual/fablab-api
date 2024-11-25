package com.example.demo.DTO;

import com.example.demo.entities.Municipio;

import lombok.Data;

@Data
public class MunicipioRequestDTO {
    private String nombre;
    private String dane;
    
    public Municipio toEntity() {
        Municipio municipio = new Municipio();
        municipio.setNombre(this.nombre);
        municipio.setDane(this.dane);
        return municipio;
    }
}
