package com.example.demo.entities;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate fecha;

    @NotNull(message = "La hora no puede estar vacía")
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "programacion_id", nullable = false)
    @NotNull(message = "La sesión debe pertenecer a una programación")
    private Programacion programacion;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    @NotNull(message = "La sesión debe tener un instructor asignado")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    @NotNull(message = "La sesión debe tener una ubicación asignada")
    private Ubicacion ubicacion;
    
    @OneToMany(mappedBy = "sesion", cascade = CascadeType.ALL)
    private List<Asistente> asistentes; 
    
    @OneToMany(mappedBy = "sesion",cascade = CascadeType.ALL)
    private List<Evidencia> evidencias;
}