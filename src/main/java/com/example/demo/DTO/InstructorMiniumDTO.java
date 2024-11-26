package com.example.demo.DTO;

import com.example.demo.entities.Instructor;

import lombok.Data;

@Data
public class InstructorMiniumDTO {
    private Long id;
    private String nombre;

    public static InstructorMiniumDTO fromEntity(Instructor instructor) {
        InstructorMiniumDTO instructorDTO = new InstructorMiniumDTO();
        instructorDTO.setId(instructor.getId());
        instructorDTO.setNombre(instructor.getNombre());
        
        return instructorDTO;
    }

}
