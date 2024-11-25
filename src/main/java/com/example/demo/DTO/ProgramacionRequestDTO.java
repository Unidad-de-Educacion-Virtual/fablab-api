package com.example.demo.DTO;

import java.time.LocalDate;

import com.example.demo.entities.Colegio;
import com.example.demo.entities.Instructor;
import com.example.demo.entities.Programacion;
import com.example.demo.entities.Taller;
import com.example.demo.entities.Ubicacion;

import lombok.Data;

@Data
public class ProgramacionRequestDTO {
    private Long colegioId;
    private Long tallerId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer cantidad;
    private String observacion;
    private Long instructorId;
    private Integer grado;
    private String grupo;
    private Long ubicacionId;

    public Programacion toEntity() {
        Programacion programacion = new Programacion();

        if (colegioId != null) {
            Colegio colegio = new Colegio();
            colegio.setId(colegioId);
            programacion.setColegio(colegio);
        }

        if (tallerId != null) {
            Taller taller = new Taller();
            taller.setId(tallerId);
            programacion.setTaller(taller);
        }

        programacion.setFechaInicio(this.fechaInicio);
        programacion.setFechaFin(this.fechaFin);
        programacion.setCantidad(this.cantidad);
        programacion.setObservacion(this.observacion);

        if (instructorId != null) {
            Instructor instructor = new Instructor();
            instructor.setId(instructorId);
            programacion.setInstructor(instructor);
        }

        programacion.setGrado(this.grado);
        programacion.setGrupo(this.grupo);

        if (ubicacionId != null) {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setId(ubicacionId);
            programacion.setUbicacion(ubicacion);
        }

        return programacion;
    }
}
