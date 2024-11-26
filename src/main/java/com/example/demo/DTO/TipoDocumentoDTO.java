package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.TipoDocumento;

import lombok.Data;

@Data
public class TipoDocumentoDTO {
    private Long id;
    private String descripcion;

    public static TipoDocumentoDTO fromEntity(TipoDocumento tipoDocumento) {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setId(tipoDocumento.getId());
        tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
        
        return tipoDocumentoDTO;
    }

    public static List<TipoDocumentoDTO> fromEntity(List<TipoDocumento> tiposDocumento) {
        ArrayList<TipoDocumentoDTO> tiposDocumentoDTO = new ArrayList<>();
        
        for (TipoDocumento tipoDocumento : tiposDocumento) {
            tiposDocumentoDTO.add(TipoDocumentoDTO.fromEntity(tipoDocumento));
        }
        
        return tiposDocumentoDTO;
    }
}
