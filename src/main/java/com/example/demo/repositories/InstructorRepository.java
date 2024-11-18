package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	
}