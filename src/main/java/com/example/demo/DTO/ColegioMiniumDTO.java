package com.example.demo.DTO;

import com.example.demo.entities.Colegio;

import lombok.Data;

@Data
public class ColegioMiniumDTO {
    private Long id;
    private String nombre;
    
    public static ColegioMiniumDTO fromEntity(Colegio colegio) {
    	ColegioMiniumDTO colegioDTO = new ColegioMiniumDTO();
    	colegioDTO.setId(colegio.getId());
    	colegioDTO.setNombre(colegio.getNombre());
    	
    	return colegioDTO;
    }
}
