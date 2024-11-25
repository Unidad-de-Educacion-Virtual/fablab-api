package com.example.demo.DTO;

import com.example.demo.entities.Municipio;

import lombok.Data;

@Data
public class MunicipioMiniumDTO {
    private Long id;
    private String nombre;
    
    public static MunicipioMiniumDTO fromEntity(Municipio municipio) {
    	MunicipioMiniumDTO municipioDTO = new MunicipioMiniumDTO();
    	
    	municipioDTO.setId(municipio.getId());
    	municipioDTO.setNombre(municipio.getNombre());
    	
    	return municipioDTO;
    }

}
