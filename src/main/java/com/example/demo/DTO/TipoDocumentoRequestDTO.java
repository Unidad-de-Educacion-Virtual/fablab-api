package com.example.demo.DTO;

import com.example.demo.entities.TipoDocumento;

import lombok.Data;

@Data
public class TipoDocumentoRequestDTO {
    private String descripcion;

    public TipoDocumento toEntity() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDescripcion(this.descripcion);

        return tipoDocumento;
    }
}
