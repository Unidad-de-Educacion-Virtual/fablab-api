package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
}

