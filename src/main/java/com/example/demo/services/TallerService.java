package com.example.demo.services;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Taller;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.TallerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
public class TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    @Autowired
    private InstructorService instructorService;
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public Taller buscarTaller(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Taller> taller = tallerRepository.findById(id);
        
        return taller.get();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Taller> listarTalleres() {
        Instructor instructor = instructorService.getCurrentInstructor();
        if(instructor != null) {
            return tallerRepository.findTalleresByInstructor(instructor);
        }else{
            return tallerRepository.findAll();
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Taller crearTaller(Taller taller) {
        return tallerRepository.save(taller);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Taller actualizarTaller(Taller taller) throws ResourceNotFoundException {
        this.showErrorIfNotExist(taller.getId());
        return tallerRepository.save(taller);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist	(Taller taller) throws ResourceNotFoundException {
    	if(taller == null || taller.getId() == null) {
    		throw new ResourceNotFoundException("El taller no existe.");
    	}
    	showErrorIfNotExist(taller.getId());
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Taller> taller = tallerRepository.findById(id);
        
        if (taller.isEmpty()) {
            throw new ResourceNotFoundException("El taller con id " + id + " no existe.");
        }
    }

}
