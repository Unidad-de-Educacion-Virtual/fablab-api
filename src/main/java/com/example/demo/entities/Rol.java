package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String descripcion;
    
	@OneToMany(mappedBy = "rol", cascade= CascadeType.ALL)
	List<User> users;
}
