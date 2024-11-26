package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Sesion;

import lombok.Data;

@Data
public class SesionDTO {
    private Long id;
    private String fecha;
    private String hora;
    private ProgramacionMiniumDTO programacion;
    private InstructorMiniumDTO instructor;
    private UbicacionDTO ubicacion;
    private Integer totalAsistentes;

    public static SesionDTO fromEntity(Sesion sesion) {
        SesionDTO sesionDTO = new SesionDTO();
        sesionDTO.setId(sesion.getId());
        
        if(sesion.getFecha() != null) {
        	sesionDTO.setFecha(sesion.getFecha().toString());
        }
        
        if(sesion.getHora() != null) {
        	 sesionDTO.setHora(sesion.getHora().toString());
        }

        if (sesion.getProgramacion() != null) {
            sesionDTO.setProgramacion(ProgramacionMiniumDTO.fromEntity(sesion.getProgramacion()));
        }
        if (sesion.getInstructor() != null) {
            sesionDTO.setInstructor(InstructorMiniumDTO.fromEntity(sesion.getInstructor()));
        }
        if (sesion.getUbicacion() != null) {
            sesionDTO.setUbicacion(UbicacionDTO.fromEntity(sesion.getUbicacion()));
        }

        return sesionDTO;
    }

    public static List<SesionDTO> fromEntity(List<Sesion> sesiones) {
        ArrayList<SesionDTO> sesionesDTO = new ArrayList<>();
        
        for (Sesion sesion : sesiones) {
            sesionesDTO.add(SesionDTO.fromEntity(sesion));
        }
        
        return sesionesDTO;
    }
}
