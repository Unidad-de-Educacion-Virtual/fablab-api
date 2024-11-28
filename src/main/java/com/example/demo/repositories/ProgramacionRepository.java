package com.example.demo.repositories;

import com.example.demo.entities.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {

    @Query("SELECT p FROM Programacion p WHERE p.instructor.id = :instructorId AND " +
           "(:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin OR :fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
    List<Programacion> findConflictsByInstructor(Long instructorId, LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT p FROM Programacion p WHERE p.ubicacion.id = :ubicacionId AND " +
           "(:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin OR :fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
    List<Programacion> findConflictsByUbicacion(Long ubicacionId, LocalDate fechaInicio, LocalDate fechaFin);

    List<Programacion> findByTallerId(Long tallerId);
    
    @Query("SELECT p FROM Programacion p WHERE p.fechaInicio > :fechaActual OR (:fechaActual BETWEEN p.fechaInicio AND p.fechaFin) ORDER BY p.fechaInicio ASC")
    List<Programacion> findAllProximasOrActuales(@Param("fechaActual") LocalDate fechaActual);
}