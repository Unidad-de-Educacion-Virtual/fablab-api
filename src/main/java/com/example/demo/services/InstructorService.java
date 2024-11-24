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

    public Optional<Instructor> actualizarInstructor(Long id, String nombre, String documento) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setNombre(nombre);
            instructor.setDocumento(documento);
            return instructorRepository.save(instructor);
        });
    }


    public Optional<Instructor> eliminarInstructor(Long id) {
        return instructorRepository.findById(id).map(instructor -> {
            instructorRepository.delete(instructor);
            return instructor;
        });
    }

}
