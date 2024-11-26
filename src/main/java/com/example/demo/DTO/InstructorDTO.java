package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Instructor;

import lombok.Data;

@Data
public class InstructorDTO {
    private Long id;
    private String nombre;
    private String documento;

    public static InstructorDTO fromEntity(Instructor instructor) {
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setId(instructor.getId());
        instructorDTO.setNombre(instructor.getNombre());
        instructorDTO.setDocumento(instructor.getDocumento());
        
        return instructorDTO;
    }

    public static List<InstructorDTO> fromEntity(List<Instructor> instructores) {
        ArrayList<InstructorDTO> instructoresDTO = new ArrayList<>();
        
        for (Instructor instructor : instructores) {
            instructoresDTO.add(InstructorDTO.fromEntity(instructor));
        }
        
        return instructoresDTO;
    }
}
