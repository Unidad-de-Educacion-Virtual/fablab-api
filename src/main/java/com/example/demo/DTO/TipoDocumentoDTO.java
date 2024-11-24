package com.example.demo.DTO;

import lombok.Data;

@Data
public class TipoDocumentoDTO {
    private Long id;
    private String descripcion;

    public TipoDocumentoDTO(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
}
