package com.example.demo.services;

import com.example.demo.DTO.ProgramacionDTO;
import com.example.demo.entities.Programacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ProgramacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
/*
 * @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
 *     @PreAuthorize("hasRole('ROLE_ADMIN')")
 * */
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
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Programacion buscarProgramacion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Programacion> programacion = programacionRepository.findById(id);
        return programacion.get();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Programacion> listarProgramaciones() {
        return programacionRepository.findAll();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Programacion crearProgramacion(Programacion programacion) throws ResourceNotFoundException {
        colegioService.showErrorIfNotExist(programacion.getColegio());
        tallerService.showErrorIfNotExist(programacion.getTaller());
        instructorService.showErrorIfNotExist(programacion.getInstructor());
        ubicacionService.showErrorIfNotExist(programacion.getUbicacion());

        List<Programacion> conflictosInstructor = programacionRepository.findConflictsByInstructor(
                programacion.getInstructor().getId(),
                programacion.getFechaInicio(),
                programacion.getFechaFin()
        );
        if (!conflictosInstructor.isEmpty()) {
            throw new IllegalArgumentException("El instructor ya tiene programaciones en el rango de fechas especificado.");
        }

        List<Programacion> conflictosUbicacion = programacionRepository.findConflictsByUbicacion(
                programacion.getUbicacion().getId(),
                programacion.getFechaInicio(),
                programacion.getFechaFin()
        );
        if (!conflictosUbicacion.isEmpty()) {
            throw new IllegalArgumentException("La ubicación ya está ocupada en el rango de fechas especificado.");
        }

        return programacionRepository.save(programacion);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Programacion actualizarProgramacion(Programacion programacion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(programacion);
        
        colegioService.showErrorIfNotExist(programacion.getColegio());
        tallerService.showErrorIfNotExist(programacion.getTaller());
        instructorService.showErrorIfNotExist(programacion.getInstructor());
        ubicacionService.showErrorIfNotExist(programacion.getUbicacion());

        return programacionRepository.save(programacion);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")	
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
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Programacion> listarProgramacionesPorTaller(Long tallerId) throws ResourceNotFoundException {
        return programacionRepository.findByTallerId(tallerId);
    }
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Programacion> listarProgramacionesPosteriores() {
    	 LocalDate fechaActual = LocalDate.now();
         List<Programacion> programaciones = programacionRepository.findAllProximasOrActuales(fechaActual);
         return programaciones;
    }
}
