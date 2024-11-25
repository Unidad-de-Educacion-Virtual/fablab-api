package com.example.demo.services;

import com.example.demo.entities.Programacion;
import com.example.demo.exceptions.ResourceAlreadyExistException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ProgramacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramacionService {

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private ColegioService colegioService;

    @Autowired
    private TallerService tallerService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private UbicacionService ubicacionService;

    public Programacion buscarProgramacion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Programacion> programacion = programacionRepository.findById(id);
        return programacion.get();
    }

    public List<Programacion> listarProgramaciones() {
        return programacionRepository.findAll();
    }

    public Programacion crearProgramacion(Programacion programacion) throws ResourceAlreadyExistException, ResourceNotFoundException {
        this.showErrorIfExist(programacion);
        
        colegioService.showErrorIfNotExist(programacion.getColegio());
        tallerService.showErrorIfNotExist(programacion.getTaller());
        instructorService.showErrorIfNotExist(programacion.getInstructor());
        ubicacionService.showErrorIfNotExist(programacion.getUbicacion());

        return programacionRepository.save(programacion);
    }

    public Programacion actualizarProgramacion(Programacion programacion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(programacion);
        
        colegioService.showErrorIfNotExist(programacion.getColegio());
        tallerService.showErrorIfNotExist(programacion.getTaller());
        instructorService.showErrorIfNotExist(programacion.getInstructor());
        ubicacionService.showErrorIfNotExist(programacion.getUbicacion());

        return programacionRepository.save(programacion);
    }

    public Programacion eliminarProgramacion(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Programacion> programacion = programacionRepository.findById(id);

        try {
            programacionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La programación no se puede eliminar porque está referenciada por otras entidades.");
        }

        return programacion.get();
    }

    public void showErrorIfNotExist(Programacion programacion) throws ResourceNotFoundException {
        if (programacion == null) {
            throw new ResourceNotFoundException("La programación no existe.");
        }
        showErrorIfNotExist(programacion.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Programacion> programacion = programacionRepository.findById(id);

        if (programacion.isEmpty()) {
            throw new ResourceNotFoundException("La programación con id " + id + " no existe.");
        }
    }

    public void showErrorIfExist(Programacion programacion) throws ResourceAlreadyExistException {
        showErrorIfExist(programacion.getId());
    }

    public void showErrorIfExist(Long id) throws ResourceAlreadyExistException {
        Optional<Programacion> programacion = programacionRepository.findById(id);

        if (programacion.isPresent()) {
            throw new ResourceAlreadyExistException("La programación con id " + id + " ya existe.");
        }
    }
}
