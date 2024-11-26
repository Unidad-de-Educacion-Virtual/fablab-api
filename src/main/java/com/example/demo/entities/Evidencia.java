package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Evidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sesion_id", nullable = false)
    private Sesion sesion;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @Column
    private String url;
    
    @Column
    private LocalDate fecha;
}