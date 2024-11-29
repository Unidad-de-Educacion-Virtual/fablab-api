package com.example.demo.services;

import com.example.demo.entities.Rol;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol buscarRol(String descripcion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(descripcion);
        Optional<Rol> rol = rolRepository.findOneByDescripcion(descripcion);
        return rol.get();
    }

    public void showErrorIfNotExist(String descripcion) throws ResourceNotFoundException {
    	if(descripcion == null) {
    		throw new ResourceNotFoundException("El rol no existe.");
    	}
    	
        Optional<Rol> rol = rolRepository.findOneByDescripcion(descripcion);
        
        if (rol.isEmpty()) {
            throw new ResourceNotFoundException("El rol no existe.");
        }
    }
}
