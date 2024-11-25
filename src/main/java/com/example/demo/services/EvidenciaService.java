package com.example.demo.services;

import com.example.demo.entities.Evidencia;
import com.example.demo.exceptions.ResourceAlreadyExistException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.EvidenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenciaService {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    @Autowired
    private SesionService sesionService;

    public Evidencia buscarEvidencia(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Evidencia> evidencia = evidenciaRepository.findById(id);
        return evidencia.get();
    }

    public List<Evidencia> listarEvidencias() {
        return evidenciaRepository.findAll();
    }

    public Evidencia crearEvidencia(Evidencia evidencia) throws ResourceAlreadyExistException, ResourceNotFoundException {
        this.showErrorIfExist(evidencia);

        sesionService.showErrorIfNotExist(evidencia.getSesion());

        return evidenciaRepository.save(evidencia);
    }

    public Evidencia actualizarEvidencia(Evidencia evidencia) throws ResourceNotFoundException {
        this.showErrorIfNotExist(evidencia);

        sesionService.showErrorIfNotExist(evidencia.getSesion());

        return evidenciaRepository.save(evidencia);
    }

    public Evidencia eliminarEvidencia(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Evidencia> evidencia = evidenciaRepository.findById(id);

        try {
            evidenciaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La evidencia no puede eliminarse porque está referenciada por otras entidades.");
        }

        return evidencia.get();
    }

    public void showErrorIfNotExist(Evidencia evidencia) throws ResourceNotFoundException {
        if (evidencia == null) {
            throw new ResourceNotFoundException("La evidencia no existe.");
        }
        showErrorIfNotExist(evidencia.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Evidencia> evidencia = evidenciaRepository.findById(id);

        if (evidencia.isEmpty()) {
            throw new ResourceNotFoundException("La evidencia con id " + id + " no existe.");
        }
    }

    public void showErrorIfExist(Evidencia evidencia) throws ResourceAlreadyExistException {
        showErrorIfExist(evidencia.getId());
    }

    public void showErrorIfExist(Long id) throws ResourceAlreadyExistException {
        Optional<Evidencia> evidencia = evidenciaRepository.findById(id);

        if (evidencia.isPresent()) {
            throw new ResourceAlreadyExistException("La evidencia con id " + id + " ya existe.");
        }
    }
}
