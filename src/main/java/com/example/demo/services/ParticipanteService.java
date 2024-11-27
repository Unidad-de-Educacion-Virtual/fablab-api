package com.example.demo.services;

import com.example.demo.entities.Participante;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ParticipanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ColegioService colegioService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Participante buscarParticipante(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Participante> participante = participanteRepository.findById(id);
        return participante.get();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Participante crearParticipante(Participante participante) throws ResourceNotFoundException {

        colegioService.showErrorIfNotExist(participante.getColegio());
        tipoDocumentoService.showErrorIfNotExist(participante.getTipoDocumento());

        return participanteRepository.save(participante);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Participante actualizarParticipante(Participante participante) throws ResourceNotFoundException {
        this.showErrorIfNotExist(participante);

        colegioService.showErrorIfNotExist(participante.getColegio());
        tipoDocumentoService.showErrorIfNotExist(participante.getTipoDocumento());

        return participanteRepository.save(participante);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Participante eliminarParticipante(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Participante> participante = participanteRepository.findById(id);

        try {
            participanteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
        	throw new ResourceReferencedByOthersException("El participante no puede eliminarse porque está referenciado por otras entidades.");
        }

        return participante.get();
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Participante participante) throws ResourceNotFoundException {
        if (participante == null || participante.getId() == null) {
            throw new ResourceNotFoundException("El participante no existe.");
        }
        showErrorIfNotExist(participante.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Participante> participante = participanteRepository.findById(id);

        if (participante.isEmpty()) {
            throw new ResourceNotFoundException("El participante con id " + id + " no existe.");
        }
    }
}
