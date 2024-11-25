package com.example.demo.DTO;

import com.example.demo.entities.Asistente;
import com.example.demo.entities.Participante;
import com.example.demo.entities.Sesion;

import lombok.Data;

@Data
public class AsistenteRequestDTO {
    private Long sesionId;
    private Long participanteId;

    public Asistente toEntity() {
        Asistente asistente = new Asistente();

        if (sesionId != null) {
            Sesion sesion = new Sesion();
            sesion.setId(sesionId);
            asistente.setSesion(sesion);
        }

        if (participanteId != null) {
            Participante participante = new Participante();
            participante.setId(participanteId);
            asistente.setParticipante(participante);
        }

        return asistente;
    }
}
