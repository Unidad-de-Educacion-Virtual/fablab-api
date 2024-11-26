package com.example.demo.repositories;

import com.example.demo.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {
    List<Programacion> findByTallerId(Long tallerId);
}
