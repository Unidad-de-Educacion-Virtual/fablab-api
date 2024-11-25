package com.example.demo.services;

import com.example.demo.entities.Municipio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public Municipio buscarMunicipio(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Municipio> municipio = municipioRepository.findById(id);
        return municipio.get();
    }

    public List<Municipio> listarMunicipios() {
        return municipioRepository.findAll();
    }

    public Municipio crearMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public Municipio actualizarMunicipio(Municipio municipio) throws ResourceNotFoundException {
        this.showErrorIfNotExist(municipio);
        return municipioRepository.save(municipio);
    }


    public Municipio eliminarMunicipio(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Municipio> municipio = municipioRepository.findById(id);

        try {
            municipioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("El municipio está referenciado por otras entidades y no se puede eliminar.");
        }

        return municipio.get();
    }

    public void showErrorIfNotExist(Municipio municipio) throws ResourceNotFoundException {
        if (municipio == null || municipio.getId() == null) {
            throw new ResourceNotFoundException("El municipio no existe.");
        }
        this.showErrorIfNotExist(municipio.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Municipio> municipio = municipioRepository.findById(id);
        if (municipio.isEmpty()) {
            throw new ResourceNotFoundException("El municipio con id " + id + " no existe.");
        }
    }
}
