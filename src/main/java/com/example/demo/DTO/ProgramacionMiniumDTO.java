package com.example.demo.DTO;

import com.example.demo.entities.Programacion;

import lombok.Data;

@Data
public class ProgramacionMiniumDTO {
    private Long id;
    private String valor = "";

    public static ProgramacionMiniumDTO fromEntity(Programacion programacion) {
        ProgramacionMiniumDTO programacionDTO = new ProgramacionMiniumDTO();
        programacionDTO.setId(programacion.getId());

        if (programacion.getTaller() != null) {
            programacionDTO.valor += programacion.getTaller().getNombre() + " - ";
        }

        programacionDTO.valor += programacion.getFechaInicio();
        
        if (programacion.getColegio() != null) {
        	programacionDTO.valor += " - " + programacion.getColegio().getNombre();
        }
        
        return programacionDTO;
    }
}
