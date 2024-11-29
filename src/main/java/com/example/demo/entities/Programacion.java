package com.example.demo.entities;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Programacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colegio_id", nullable = false)
    @NotNull(message = "El colegio no puede estar vacío")
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "taller_id", nullable = false)
    @NotNull(message = "El taller no puede estar vacío")
    private Taller taller;

    @NotNull(message = "La fecha de inicio no puede estar vacía")
    @Column(nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin no puede estar vacía")
    @Column(nullable = false)
    private LocalDate fechaFin;

    private Integer cantidad;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    @NotNull(message = "El instructor no puede estar vacío")
    private Instructor instructor;

    private Integer grado;

    private String grupo;

    @ManyToOne
    @NotNull(message = "La ubicación no puede estar vacía")
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private Ubicacion ubicacion;
    
    @OneToMany(mappedBy = "programacion")
    private List<Inscripcion> inscripciones;

}