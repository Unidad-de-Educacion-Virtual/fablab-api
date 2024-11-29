package com.example.demo.services;

import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User buscarUsuario(String email) throws ResourceNotFoundException {
        this.showErrorIfNotExist(email);
        Optional<User> user = userRepository.findOneByEmail(email);
        return user.get();
    }
    
    public void showErrorIfNotExist(User user) throws ResourceNotFoundException {
    	if(user == null) {
    		throw new ResourceNotFoundException("El usuario no existe.");
    	}
    	
        showErrorIfNotExist(user.getId());
    }

    public void showErrorIfNotExist(String email) throws ResourceNotFoundException {
    	if(email == null) {
    		throw new ResourceNotFoundException("El usuario no existe.");
    	}
    	
        Optional<User> user = userRepository.findOneByEmail(email);
        
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("El usuario no existe.");
        }
    }
    
    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
    	if(id == null) {
    		throw new ResourceNotFoundException("El usuario no existe.");
    	}
    	
        Optional<User> user = userRepository.findById(id);
        
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("El usuario no existe.");
        }
    }
}
