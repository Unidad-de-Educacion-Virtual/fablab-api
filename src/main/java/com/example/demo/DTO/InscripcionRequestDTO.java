package com.example.demo.DTO;

import com.example.demo.entities.Inscripcion;
import com.example.demo.entities.Participante;
import com.example.demo.entities.Programacion;

import lombok.Data;

@Data
public class InscripcionRequestDTO {
    private Long participanteId;
    private Long programacionId;

    public Inscripcion toEntity() {
        Inscripcion inscripcion = new Inscripcion();

        if (participanteId != null) {
            Participante participante = new Participante();
            participante.setId(participanteId);
            inscripcion.setParticipante(participante);
        }

        if (programacionId != null) {
            Programacion programacion = new Programacion();
            programacion.setId(programacionId);
            inscripcion.setProgramacion(programacion);
        }

        return inscripcion;
    }
}
