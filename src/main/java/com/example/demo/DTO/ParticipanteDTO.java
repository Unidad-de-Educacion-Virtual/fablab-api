package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Participante;

import lombok.Data;

@Data
public class ParticipanteDTO {
    private Long id;
    private String nombre;
    private ColegioMiniumDTO colegio;
    private TipoDocumentoDTO tipoDocumento;

    public static ParticipanteDTO fromEntity(Participante participante) {
        ParticipanteDTO participanteDTO = new ParticipanteDTO();
        participanteDTO.setId(participante.getId());
        participanteDTO.setNombre(participante.getNombre());

        if (participante.getColegio() != null) {
            participanteDTO.setColegio(ColegioMiniumDTO.fromEntity(participante.getColegio()));
        }
        if (participante.getTipoDocumento() != null) {
            participanteDTO.setTipoDocumento(TipoDocumentoDTO.fromEntity(participante.getTipoDocumento()));
        }

        return participanteDTO;
    }

    public static List<ParticipanteDTO> fromEntity(List<Participante> participantes) {
        ArrayList<ParticipanteDTO> participantesDTO = new ArrayList<>();
        
        for (Participante participante : participantes) {
            participantesDTO.add(ParticipanteDTO.fromEntity(participante));
        }
        
        return participantesDTO;
    }
}
