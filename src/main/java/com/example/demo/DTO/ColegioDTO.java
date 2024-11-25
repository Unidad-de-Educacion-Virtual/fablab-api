package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Colegio;

import lombok.Data;

@Data
public class ColegioDTO {
    private Long id;
    private String nombre;
    private String dane;
    private MunicipioMiniumDTO municipio;
    
    public static ColegioDTO fromEntity(Colegio colegio) {
    	ColegioDTO colegioDTO = new ColegioDTO();
    	colegioDTO.setId(colegio.getId());
    	colegioDTO.setNombre(colegio.getNombre());
    	colegioDTO.setDane(colegio.getDane());
    	
    	if(colegio.getMunicipio() != null) {
    		colegioDTO.setMunicipio(MunicipioMiniumDTO.fromEntity(colegio.getMunicipio()));
    	}
    	
    	return colegioDTO;
    }
    
    public static List<ColegioDTO> fromEntity(List<Colegio> colegios) {
    	ArrayList<ColegioDTO> colegiosDTO = new ArrayList<ColegioDTO>();
    	
    	for(Colegio colegio : colegios) {
    		colegiosDTO.add(ColegioDTO.fromEntity(colegio));
    	}
    	
        return colegiosDTO;
    }
}
