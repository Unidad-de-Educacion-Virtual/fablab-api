package com.example.demo.services;

import com.example.demo.entities.Colegio;
import com.example.demo.entities.Taller;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.TallerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    public Taller buscarTaller(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Taller> taller = tallerRepository.findById(id);
        
        return taller.get();
    }

    public List<Taller> listarTalleres() {
        return tallerRepository.findAll();
    }

    public Taller crearTaller(Taller taller) {
        return tallerRepository.save(taller);
    }

    public Taller actualizarTaller(Taller taller) throws ResourceNotFoundException {
        this.showErrorIfNotExist(taller.getId());
        return tallerRepository.save(taller);
    }

    public Taller eliminarTaller(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Taller> taller = tallerRepository.findById(id);
        
        try {
            tallerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("El taller no se puede eliminar porque está siendo utilizado en otras entidades.");
        }
        
        return taller.get();
    }

    public void showErrorIfNotExist	(Taller taller) throws ResourceNotFoundException {
    	if(taller == null || taller.getId() == null) {
    		throw new ResourceNotFoundException("El taller no existe.");
    	}
    	showErrorIfNotExist(taller.getId());
    }
    
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Taller> taller = tallerRepository.findById(id);
        
        if (taller.isEmpty()) {
            throw new ResourceNotFoundException("El taller con id " + id + " no existe.");
        }
    }

}
