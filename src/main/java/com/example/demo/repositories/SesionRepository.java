package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Long> {

	List<Sesion> findByProgramacionId(Long programacionId);

	@Query("SELECT COUNT(a) FROM Asistente a WHERE a.sesion.id = :sesionId")
    int countAsistentesBySesionId(@Param("sesionId") Long sesionId);
}
