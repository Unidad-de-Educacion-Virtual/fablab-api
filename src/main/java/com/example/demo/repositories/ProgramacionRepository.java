package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Programacion;

public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {

}
