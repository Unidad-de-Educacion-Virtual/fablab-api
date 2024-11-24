package com.example.demo.DTO;

import lombok.Data;

@Data
public class MunicipioDTO {
    private Long id;
    private String nombre;
    private String dane;

    public MunicipioDTO(Long id, String nombre, String dane) {
        this.id = id;
        this.nombre = nombre;
        this.dane = dane;
    }
}
