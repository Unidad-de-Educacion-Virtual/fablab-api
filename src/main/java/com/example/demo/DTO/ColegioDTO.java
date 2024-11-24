package com.example.demo.DTO;

import lombok.Data;

@Data
public class ColegioDTO {
    private Long id;
    private String nombre;
    private String dane;
    private MunicipioDTO municipio;

    public ColegioDTO(Long id, String nombre,String dane, MunicipioDTO municipio) {
        this.id = id;
        this.nombre = nombre;
        this.dane = dane;
        this.municipio = municipio;
    }
}
