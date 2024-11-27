package com.example.demo.controllers;


import com.example.demo.DTO.LoginRequestDTO;
import com.example.demo.DTO.LoginResponseDTO;
import com.example.demo.auth.JwtUtil;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired UserService userService;
	@Autowired AuthenticationManager authenticationManager;
	@Autowired JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginReq)  {
        try {
        	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            String email = authentication.getName();
            User user = userService.buscarUsuario(email);
            String token = jwtUtil.createToken(user);
            LoginResponseDTO loginRes = new LoginResponseDTO(token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e){
        	throw new BadCredentialsException("Email o contraseña inválidos");
        }
    }
}