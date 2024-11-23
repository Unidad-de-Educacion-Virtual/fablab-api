package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Instructor;
import com.example.demo.repositories.InstructorRepository;

@Service
public class InstructorService {
	private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    
    public Instructor buscarInstructor(long id) {
     return instructorRepository.getReferenceById(id);
    } 
    
    public List<Instructor> listarInstructor() {
        return instructorRepository.findAll();
    }

    public Instructor crearInstructor(Instructor Instructor) {
        return instructorRepository.save(Instructor);
    }

    public Optional<Instructor> actualizarInstructor(Long id, Instructor instructorActualizado) {
        return instructorRepository.findById(id).map(Instructor -> {
            Instructor.setNombre(instructorActualizado.getNombre());
            Instructor.setDocumento(instructorActualizado.getDocumento());
            return instructorRepository.save(Instructor);
        });
    }

    public void eliminarInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}
