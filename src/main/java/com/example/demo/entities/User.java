package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "El usuario debe tener documento")
    private String email;
	
	@Column(nullable = false)
	@NotNull(message = "El usuario debe tener contraseña")
    private String password;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	@NotNull(message = "El usuario debe tener un rol asignado")
	private Rol rol;
	
    @OneToOne
    @JoinColumn(name = "instructor_id", nullable = true)
    private Instructor instructor;
}
