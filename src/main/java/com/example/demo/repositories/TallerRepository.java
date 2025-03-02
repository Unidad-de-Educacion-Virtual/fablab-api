package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Taller;

public interface TallerRepository extends JpaRepository<Taller, Long> {

   @Query("SELECT DISTINCT t FROM Taller t JOIN Programacion p ON t.id = p.taller.id WHERE p.instructor = :instructor")
    List<Taller> findTalleresByInstructor(@Param("instructor") Instructor instructor);    
}
