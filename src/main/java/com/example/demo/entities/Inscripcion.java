package com.example.demo.entities;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"participante_id", "programacion_id"}))
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    @JsonIgnore
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "programacion_id", nullable = false)
    @JsonIgnore
    private Programacion programacion;

    private LocalDate fecha = LocalDate.now();

}