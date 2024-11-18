package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String documento;

}
