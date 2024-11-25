package com.example.demo.services;

import com.example.demo.entities.Instructor;
import com.example.demo.exceptions.ResourceAlreadyExistException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.InstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor buscarInstructor(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        return instructor.get();
    }

    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    public Instructor crearInstructor(Instructor instructor) throws ResourceAlreadyExistException {
        this.showErrorIfExist(instructor);
        return instructorRepository.save(instructor);
    }

    public Instructor actualizarInstructor(Instructor instructor) throws ResourceNotFoundException {
        this.showErrorIfNotExist(instructor.getId());
        return instructorRepository.save(instructor);
    }

    public Instructor eliminarInstructor(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        try {
            instructorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("El instructor no se puede eliminar porque está siendo utilizado en otras entidades.");
        }
        
        return instructor.get();
    }

    public void showErrorIfNotExist(Instructor instructor) throws ResourceNotFoundException {
        if (instructor == null) {
            throw new ResourceNotFoundException("El instructor no existe.");
        }
        showErrorIfNotExist(instructor.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        if (instructor.isEmpty()) {
            throw new ResourceNotFoundException("El instructor con id " + id + " no existe.");
        }
    }

    public void showErrorIfExist(Instructor instructor) throws ResourceAlreadyExistException {
        showErrorIfExist(instructor.getId());
    }

    public void showErrorIfExist(Long id) throws ResourceAlreadyExistException {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        if (instructor.isPresent()) {
            throw new ResourceAlreadyExistException("El instructor con id " + id + " ya existe.");
        }
    }
}
