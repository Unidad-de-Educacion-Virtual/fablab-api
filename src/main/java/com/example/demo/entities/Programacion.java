package com.example.demo.entities;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Programacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colegio_id", nullable = false)
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "taller_id", nullable = false)
    private Taller taller;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Integer cantidad;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    private Integer grado;

    private String grupo;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private Ubicacion ubicacion;
    
    @OneToMany(mappedBy = "programacion")
    private List<Inscripcion> inscripciones;

}