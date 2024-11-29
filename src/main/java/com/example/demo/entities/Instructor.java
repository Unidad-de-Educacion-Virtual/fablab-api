package com.example.demo.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El instructor debe tener nombre")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "El instructor debe tener documento")
    @Column(nullable = false)
    private String documento;
    
    @NotNull(message = "El instructor debe estar asociado a un usuario")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
