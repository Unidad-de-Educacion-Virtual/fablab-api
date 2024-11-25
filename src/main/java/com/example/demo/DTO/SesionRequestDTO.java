package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Programacion;
import com.example.demo.entities.Sesion;
import com.example.demo.entities.Ubicacion;

import lombok.Data;

@Data
public class SesionRequestDTO {
    private LocalDate fecha;
    private LocalTime hora;
    private Long programacionId;
    private Long instructorId;
    private Long ubicacionId;

    public Sesion toEntity() {
        Sesion sesion = new Sesion();
        sesion.setFecha(this.fecha);
        sesion.setHora(this.hora);

        if (programacionId != null) {
            Programacion programacion = new Programacion();
            programacion.setId(programacionId);
            sesion.setProgramacion(programacion);
        }

        if (instructorId != null) {
            Instructor instructor = new Instructor();
            instructor.setId(instructorId);
            sesion.setInstructor(instructor);
        }

        if (ubicacionId != null) {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setId(ubicacionId);
            sesion.setUbicacion(ubicacion);
        }

        return sesion;
    }
}
