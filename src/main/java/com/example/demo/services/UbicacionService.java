package com.example.demo.services;

import com.example.demo.entities.Ubicacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.UbicacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion buscarUbicacion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Ubicacion> ubicacion = ubicacionRepository.findById(id);
        
        return ubicacion.get();
    }

    public List<Ubicacion> listarUbicaciones() {
        return ubicacionRepository.findAll();
    }

    public Ubicacion crearUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(ubicacion.getId());
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion eliminarUbicacion(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Ubicacion> ubicacion = ubicacionRepository.findById(id);
        
        try {
            ubicacionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La ubicacion no se puede eliminar porque está siendo utilizada en otras entidades.");
        }
        
        return ubicacion.get();
    }

    public void showErrorIfNotExist(Ubicacion ubicacion) throws ResourceNotFoundException {
        if (ubicacion == null || ubicacion.getId() == null) {
            throw new ResourceNotFoundException("La ubicacion no existe.");
        }
        showErrorIfNotExist(ubicacion.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Ubicacion> ubicacion = ubicacionRepository.findById(id);
        
        if (ubicacion.isEmpty()) {
            throw new ResourceNotFoundException("La ubicacion con id " + id + " no existe.");
        }
    }
}
