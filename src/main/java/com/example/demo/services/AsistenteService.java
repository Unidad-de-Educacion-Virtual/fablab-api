package com.example.demo.services;

import com.example.demo.entities.Asistente;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.AsistenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenteService {

    @Autowired
    private AsistenteRepository asistenteRepository;

    @Autowired
    private SesionService sesionService;

    @Autowired
    private ParticipanteService participanteService;

    public Asistente buscarAsistente(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Asistente> asistente = asistenteRepository.findById(id);
        return asistente.get();
    }

    public List<Asistente> listarAsistentes() {
        return asistenteRepository.findAll();
    }

    public Asistente crearAsistente(Asistente asistente) throws ResourceNotFoundException {

        sesionService.showErrorIfNotExist(asistente.getSesion());
        participanteService.showErrorIfNotExist(asistente.getParticipante());

        return asistenteRepository.save(asistente);
    }

    public Asistente actualizarAsistente(Asistente asistente) throws ResourceNotFoundException {
        this.showErrorIfNotExist(asistente);

        sesionService.showErrorIfNotExist(asistente.getSesion());
        participanteService.showErrorIfNotExist(asistente.getParticipante());

        return asistenteRepository.save(asistente);
    }

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

    public void showErrorIfNotExist(Asistente asistente) throws ResourceNotFoundException {
        if (asistente == null || asistente.getId() == null) {
            throw new ResourceNotFoundException("El asistente no existe.");
        }
        showErrorIfNotExist(asistente.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Asistente> asistente = asistenteRepository.findById(id);

        if (asistente.isEmpty()) {
            throw new ResourceNotFoundException("El asistente con id " + id + " no existe.");
        }
    }
}
