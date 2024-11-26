package com.example.demo.DTO;

import com.example.demo.entities.Instructor;

import lombok.Data;

@Data
public class InstructorRequestDTO {
    private String nombre;
    private String documento;

    public Instructor toEntity() {
        Instructor instructor = new Instructor();
        instructor.setNombre(this.nombre);
        instructor.setDocumento(this.documento);

        return instructor;
    }
}
