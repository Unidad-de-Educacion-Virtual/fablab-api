package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Inscripcion;

import lombok.Data;

@Data
public class InscripcionDTO {
    private Long id;
    private ParticipanteMiniumDTO participante;
    private ProgramacionMiniumDTO programacion;
    private String fecha;

    public static InscripcionDTO fromEntity(Inscripcion inscripcion) {
        InscripcionDTO inscripcionDTO = new InscripcionDTO();
        inscripcionDTO.setId(inscripcion.getId());
        inscripcionDTO.setFecha(inscripcion.getFecha().toString());

        if (inscripcion.getParticipante() != null) {
            inscripcionDTO.setParticipante(ParticipanteMiniumDTO.fromEntity(inscripcion.getParticipante()));
        }
        if (inscripcion.getProgramacion() != null) {
            inscripcionDTO.setProgramacion(ProgramacionMiniumDTO.fromEntity(inscripcion.getProgramacion()));
        }

        return inscripcionDTO;
    }

    public static List<InscripcionDTO> fromEntity(List<Inscripcion> inscripciones) {
        ArrayList<InscripcionDTO> inscripcionesDTO = new ArrayList<>();
        
        for (Inscripcion inscripcion : inscripciones) {
            inscripcionesDTO.add(InscripcionDTO.fromEntity(inscripcion));
        }
        
        return inscripcionesDTO;
    }
}
