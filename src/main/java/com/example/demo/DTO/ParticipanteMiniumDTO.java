package com.example.demo.DTO;



import com.example.demo.entities.Participante;

import lombok.Data;

@Data
public class ParticipanteMiniumDTO {
    private Long id;
    private String nombre;

    public static ParticipanteMiniumDTO fromEntity(Participante participante) {
        ParticipanteMiniumDTO participanteDTO = new ParticipanteMiniumDTO();
        participanteDTO.setId(participante.getId());
        participanteDTO.setNombre(participante.getNombre());

        return participanteDTO;
    }
}
