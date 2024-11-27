package com.example.demo.services;

import com.example.demo.entities.Programacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ProgramacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
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

    public Programacion crearProgramacion(Programacion programacion) throws ResourceNotFoundException {
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
        if (programacion == null || programacion.getId() == null) {
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
    
    public List<Programacion> listarProgramacionesPorTaller(Long tallerId) throws ResourceNotFoundException {
        return programacionRepository.findByTallerId(tallerId);
    }
    
}
