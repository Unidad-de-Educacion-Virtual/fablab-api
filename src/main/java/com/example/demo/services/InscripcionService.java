package com.example.demo.services;

import com.example.demo.entities.Inscripcion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.InscripcionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private ProgramacionService programacionService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Inscripcion buscarInscripcion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);
        return inscripcion.get();
    }
   @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Inscripcion crearInscripcion(Inscripcion inscripcion) throws ResourceNotFoundException {

        participanteService.showErrorIfNotExist(inscripcion.getParticipante());
        programacionService.showErrorIfNotExist(inscripcion.getProgramacion());

        return inscripcionRepository.save(inscripcion);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Inscripcion actualizarInscripcion(Inscripcion inscripcion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(inscripcion);

        participanteService.showErrorIfNotExist(inscripcion.getParticipante());
        programacionService.showErrorIfNotExist(inscripcion.getProgramacion());

        return inscripcionRepository.save(inscripcion);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Inscripcion eliminarInscripcion(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);

        try {
            inscripcionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La inscripción no puede eliminarse porque está referenciada por otras entidades.");
        }

        return inscripcion.get();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Inscripcion inscripcion) throws ResourceNotFoundException {
        if (inscripcion == null || inscripcion.getId() == null) {
            throw new ResourceNotFoundException("La inscripción no existe.");
        }
        showErrorIfNotExist(inscripcion.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isEmpty()) {
            throw new ResourceNotFoundException("La inscripción con id " + id + " no existe.");
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
	public List<Inscripcion> listarInscripcionesPorProgramacion(Long programacionId) {
		return inscripcionRepository.findAllByProgramacionId(programacionId);
	}
}
