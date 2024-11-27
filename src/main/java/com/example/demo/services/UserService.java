package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User buscarUsuario(String email) throws ResourceNotFoundException {
        this.showErrorIfNotExist(email);
        Optional<User> user = userRepository.findById(email);
        return user.get();
    }

    public void showErrorIfNotExist(User user) throws ResourceNotFoundException {
        if (user == null || user.getEmail() == null) {
            throw new ResourceNotFoundException("El usuario no existe.");
        }
        showErrorIfNotExist(user.getEmail());
    }

    public void showErrorIfNotExist(String email) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(email);
        
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("El usuario no existe.");
        }
    }
}
