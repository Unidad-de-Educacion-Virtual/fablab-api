package com.example.demo.DTO;

import lombok.Data;

@Data
public class ColegioRequestDTO {
    private String nombre;
    private String dane;
    private Long municipioId; // Solo el ID del municipio
}
