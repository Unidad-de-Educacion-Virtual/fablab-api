package com.example.demo.services;

import com.example.demo.entities.Participante;
import com.example.demo.exceptions.ResourceAlreadyExistException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ParticipanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Participante buscarParticipante(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Participante> participante = participanteRepository.findById(id);
        return participante.get();
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    public Participante crearParticipante(Participante participante) throws ResourceAlreadyExistException, ResourceNotFoundException {
        this.showErrorIfExist(participante);

        colegioService.showErrorIfNotExist(participante.getColegio());
        tipoDocumentoService.showErrorIfNotExist(participante.getTipoDocumento());

        return participanteRepository.save(participante);
    }

    public Participante actualizarParticipante(Participante participante) throws ResourceNotFoundException {
        this.showErrorIfNotExist(participante);

        colegioService.showErrorIfNotExist(participante.getColegio());
        tipoDocumentoService.showErrorIfNotExist(participante.getTipoDocumento());

        return participanteRepository.save(participante);
    }

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

    public void showErrorIfNotExist(Participante participante) throws ResourceNotFoundException {
        if (participante == null) {
            throw new ResourceNotFoundException("El participante no existe.");
        }
        showErrorIfNotExist(participante.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Participante> participante = participanteRepository.findById(id);

        if (participante.isEmpty()) {
            throw new ResourceNotFoundException("El participante con id " + id + " no existe.");
        }
    }

    public void showErrorIfExist(Participante participante) throws ResourceAlreadyExistException {
        showErrorIfExist(participante.getId());
    }

    public void showErrorIfExist(Long id) throws ResourceAlreadyExistException {
        Optional<Participante> participante = participanteRepository.findById(id);

        if (participante.isPresent()) {
            throw new ResourceAlreadyExistException("El participante con id " + id + " ya existe.");
        }
    }
}
