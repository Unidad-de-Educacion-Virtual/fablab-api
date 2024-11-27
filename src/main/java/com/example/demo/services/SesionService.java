package com.example.demo.services;

import com.example.demo.entities.Sesion;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.SesionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
/*
 * @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
 *     @PreAuthorize("hasRole('ROLE_ADMIN')")
 * */
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private UbicacionService ubicacionService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Sesion buscarSesion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Sesion> sesion = sesionRepository.findById(id);
        return sesion.get();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Sesion> listarSesiones() {
        return sesionRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Sesion crearSesion(Sesion sesion) throws ResourceNotFoundException {
        programacionService.showErrorIfNotExist(sesion.getProgramacion());
        instructorService.showErrorIfNotExist(sesion.getInstructor());
        ubicacionService.showErrorIfNotExist(sesion.getUbicacion());

        return sesionRepository.save(sesion);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Sesion actualizarSesion(Sesion sesion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(sesion);

        programacionService.showErrorIfNotExist(sesion.getProgramacion());
        instructorService.showErrorIfNotExist(sesion.getInstructor());
        ubicacionService.showErrorIfNotExist(sesion.getUbicacion());

        return sesionRepository.save(sesion);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Sesion eliminarSesion(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Sesion> sesion = sesionRepository.findById(id);

        try {
            sesionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La sesión no puede eliminarse porque está referenciada por otras entidades.");
        }

        return sesion.get();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Sesion sesion) throws ResourceNotFoundException {
        if (sesion == null || sesion.getId() == null) {
            throw new ResourceNotFoundException("La sesión no existe.");
        }
        showErrorIfNotExist(sesion.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Sesion> sesion = sesionRepository.findById(id);

        if (sesion.isEmpty()) {
            throw new ResourceNotFoundException("La sesión con id " + id + " no existe.");
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
	public List<Sesion> listarSesionesPorProgramacion(Long programacionId) throws ResourceNotFoundException{
		return sesionRepository.findByProgramacionId(programacionId);
	}
}
