package com.example.demo.DTO;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.User;

import lombok.Data;

@Data
public class InstructorRequestDTO {
    private String nombre;
    private String documento;
    private String password;
    private String email;

    public Instructor toEntity() {
        Instructor instructor = new Instructor();
        instructor.setNombre(this.nombre);
        instructor.setDocumento(this.documento);
        
        if(email != null) {
        	User user = new User();
        	user.setEmail(email);
        	user.setPassword(password);
        	instructor.setUser(user);
        }

        return instructor;
    }
}
