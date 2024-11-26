package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Programacion;

import lombok.Data;

@Data
public class ProgramacionDTO {
    private Long id;
    private ColegioMiniumDTO colegio;
    private TallerMiniumDTO taller;
    private String fechaInicio;
    private String fechaFin;
    private Integer cantidad;
    private String observacion;
    private InstructorMiniumDTO instructor;
    private Integer grado;
    private String grupo;
    private UbicacionDTO ubicacion;

    public static ProgramacionDTO fromEntity(Programacion programacion) {
        ProgramacionDTO programacionDTO = new ProgramacionDTO();
        programacionDTO.setId(programacion.getId());
        programacionDTO.setFechaInicio(programacion.getFechaInicio().toString());
        programacionDTO.setFechaFin(programacion.getFechaFin().toString());
        programacionDTO.setCantidad(programacion.getCantidad());
        programacionDTO.setObservacion(programacion.getObservacion());
        programacionDTO.setGrado(programacion.getGrado());
        programacionDTO.setGrupo(programacion.getGrupo());

        if (programacion.getColegio() != null) {
            programacionDTO.setColegio(ColegioMiniumDTO.fromEntity(programacion.getColegio()));
        }
        if (programacion.getTaller() != null) {
            programacionDTO.setTaller(TallerMiniumDTO.fromEntity(programacion.getTaller()));
        }
        if (programacion.getInstructor() != null) {
            programacionDTO.setInstructor(InstructorMiniumDTO.fromEntity(programacion.getInstructor()));
        }
        if (programacion.getUbicacion() != null) {
            programacionDTO.setUbicacion(UbicacionDTO.fromEntity(programacion.getUbicacion()));
        }

        return programacionDTO;
    }

    public static List<ProgramacionDTO> fromEntity(List<Programacion> programaciones) {
        ArrayList<ProgramacionDTO> programacionesDTO = new ArrayList<>();
        
        for (Programacion programacion : programaciones) {
            programacionesDTO.add(ProgramacionDTO.fromEntity(programacion));
        }
        
        return programacionesDTO;
    }
}
