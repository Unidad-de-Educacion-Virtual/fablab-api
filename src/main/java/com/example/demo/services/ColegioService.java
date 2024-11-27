package com.example.demo.services;

import com.example.demo.entities.Colegio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.ColegioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ColegioService {
	@Autowired
	private ColegioRepository colegioRepository;
	
	@Autowired
	private MunicipioService municipioService;

    public Colegio buscarColegio(Long id) {
    	this.showErrorIfNotExist(id);
    	Optional<Colegio> colegio = colegioRepository.findById(id);
    	
        return colegio.get();
    }

    public List<Colegio> listarColegios() {
    	return colegioRepository.findAll();
    }
    
    public Colegio crearColegio(Colegio colegio) throws ResourceNotFoundException {
    	municipioService.showErrorIfNotExist(colegio.getMunicipio());
    	
    	return colegioRepository.save(colegio);
    }
    
    public Colegio actualizarColegio(Colegio colegio) throws ResourceNotFoundException {
    	this.showErrorIfNotExist(colegio);
    	municipioService.showErrorIfNotExist(colegio.getMunicipio());
    	
    	return colegioRepository.save(colegio);
    }

    public Colegio eliminarColegio(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
    	this.showErrorIfNotExist(id);
    	Optional<Colegio> colegio = colegioRepository.findById(id);
    	
    	try {
    		colegioRepository.deleteById(id);
    	} catch(DataIntegrityViolationException e) {
    		throw new ResourceReferencedByOthersException("El colegio se encuentra referenciado por otras entidades.");
    	}
    	
    	return colegio.get();
    }
    
    public void showErrorIfNotExist	(Colegio colegio) throws ResourceNotFoundException {
    	if(colegio == null || colegio.getId() == null) {
    		throw new ResourceNotFoundException("El colegio no existe.");
    	}
    	showErrorIfNotExist(colegio.getId());
    }
    
    public void showErrorIfNotExist	(Long id) throws ResourceNotFoundException {
    	Optional<Colegio> colegio = colegioRepository.findById(id);
    	
    	if(colegio.isEmpty()) {
    		throw new ResourceNotFoundException("El colegio con id " + id + " no existe.");
    	}
    }
}
