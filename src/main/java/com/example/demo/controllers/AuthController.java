package com.example.demo.controllers;


import com.example.demo.DTO.LoginRequestDTO;
import com.example.demo.DTO.LoginResponseDTO;
import com.example.demo.auth.JwtUtil;
import com.example.demo.entities.User;

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

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginReq)  {
        try {
        	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            String email = authentication.getName();
            User user = new User();
            user.setEmail(email);
            String token = jwtUtil.createToken(user);
            LoginResponseDTO loginRes = new LoginResponseDTO(email, token);

            return ResponseEntity.ok(loginRes);
        } catch (BadCredentialsException e){
        	throw new BadCredentialsException("Email o contraseña inválidos");
        }
    }
}