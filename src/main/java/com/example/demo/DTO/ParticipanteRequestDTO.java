package com.example.demo.DTO;

import com.example.demo.entities.Colegio;
import com.example.demo.entities.Participante;
import com.example.demo.entities.TipoDocumento;

import lombok.Data;

@Data
public class ParticipanteRequestDTO {
    private String nombre;
    private Long colegioId;
    private Long tipoDocumentoId;

    public Participante toEntity() {
        Participante participante = new Participante();

        participante.setNombre(this.nombre);

        if (colegioId != null) {
            Colegio colegio = new Colegio();
            colegio.setId(colegioId);
            participante.setColegio(colegio);
        }

        if (tipoDocumentoId != null) {
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(tipoDocumentoId);
            participante.setTipoDocumento(tipoDocumento);
        }

        return participante;
    }
}
