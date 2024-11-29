package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
	public Optional<Rol> findOneByDescripcion(String descripcion);
}

