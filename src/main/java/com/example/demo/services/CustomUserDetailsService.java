package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	try {
    		User user = userService.buscarUsuario(email);

        	UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(user.getRol().getDescripcion())
                        .build();
        	return userDetails;
    	} catch (ResourceNotFoundException e) {
    		throw new UsernameNotFoundException(e.getMessage());
    	}
    }
}