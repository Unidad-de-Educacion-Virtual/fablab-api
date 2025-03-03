package com.example.demo.services;

import com.example.demo.entities.Asistente;
import com.example.demo.entities.Inscripcion;
import com.example.demo.entities.Participante;
import com.example.demo.entities.Programacion;
import com.example.demo.entities.Sesion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.AsistenteRepository;
import com.example.demo.repositories.ParticipanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
public class AsistenteService {
	
    @Autowired
    private AsistenteRepository asistenteRepository;

    @Autowired
    private SesionService sesionService;

    @Autowired
    private ParticipanteService participanteService;
    

    @Autowired
    private InscripcionService inscripcionService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Asistente buscarAsistente(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Asistente> asistente = asistenteRepository.findById(id);
        return asistente.get();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Asistente> listarAsistentes() {
        return asistenteRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Asistente crearAsistente(Asistente asistente) throws ResourceNotFoundException {

        sesionService.showErrorIfNotExist(asistente.getSesion());
        participanteService.showErrorIfNotExist(asistente.getParticipante());
        
        Sesion sesion = sesionService.buscarSesion(asistente.getSesion().getId());
        List<Inscripcion> inscripciones = sesion.getProgramacion().getInscripciones();
        List<Participante> participantes = new ArrayList<Participante>();
        
        for(Inscripcion inscripcion : inscripciones) {
        	participantes.add(inscripcion.getParticipante());
        }
        
        if(!participantes.contains(asistente.getParticipante())) {
        	throw new IllegalArgumentException("El participante debe estar registrado en la programación");
        }
        
        return asistenteRepository.save(asistente);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Asistente actualizarAsistente(Asistente asistente) throws ResourceNotFoundException {
        this.showErrorIfNotExist(asistente);

        sesionService.showErrorIfNotExist(asistente.getSesion());
        participanteService.showErrorIfNotExist(asistente.getParticipante());

        return asistenteRepository.save(asistente);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Asistente eliminarAsistente(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Asistente> asistente = asistenteRepository.findById(id);

        try {
            asistenteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("El asistente no puede eliminarse porque está referenciado por otras entidades.");
        }

        return asistente.get();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Asistente asistente) throws ResourceNotFoundException {
        if (asistente == null || asistente.getId() == null) {
            throw new ResourceNotFoundException("El asistente no existe.");
        }
        showErrorIfNotExist(asistente.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Asistente> asistente = asistenteRepository.findById(id);

        if (asistente.isEmpty()) {
            throw new ResourceNotFoundException("El asistente con id " + id + " no existe.");
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
	public List<Asistente> listarAsistentesPorSesion(Long sesionId) {
		return asistenteRepository.findBySesionId(sesionId);
	}
    
}
