package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Programacion;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {

    @Query("SELECT p FROM Programacion p WHERE p.instructor.id = :instructorId AND " +
           "(:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin OR :fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
    List<Programacion> findConflictsByInstructor(Long instructorId, LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT p FROM Programacion p WHERE p.ubicacion.id = :ubicacionId AND " +
           "(:fechaInicio BETWEEN p.fechaInicio AND p.fechaFin OR :fechaFin BETWEEN p.fechaInicio AND p.fechaFin)")
    List<Programacion> findConflictsByUbicacion(Long ubicacionId, LocalDate fechaInicio, LocalDate fechaFin);

    List<Programacion> findByTallerIdAndInstructor(Long tallerId, Instructor instructor);
    
    List<Programacion> findByInstructor(Instructor instructor);

    List<Programacion> findByTaller_Id(Long tallerId);
    
    @Query("SELECT p FROM Programacion p WHERE p.instructor = :instructor AND (p.fechaInicio > :fechaActual OR (:fechaActual BETWEEN p.fechaInicio AND p.fechaFin)) ORDER BY p.fechaInicio ASC")
    List<Programacion> findAllProximasOrActualesByInstructor(@Param("fechaActual") LocalDate fechaActual, @Param("instructor") Instructor instructor);
}