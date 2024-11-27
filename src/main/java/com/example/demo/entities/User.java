package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
    private String email;
	
	@Column(nullable = false)
    private String password;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;
}
