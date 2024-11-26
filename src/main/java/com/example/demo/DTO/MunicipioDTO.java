package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Municipio;

import lombok.Data;

@Data
public class MunicipioDTO {
    private Long id;
    private String nombre;
    private String dane;
    
    public static MunicipioDTO fromEntity(Municipio municipio) {
    	MunicipioDTO municipioDTO = new MunicipioDTO();
    	
    	municipioDTO.setId(municipio.getId());
    	municipioDTO.setNombre(municipio.getNombre());
    	municipioDTO.setDane(municipio.getDane());
    	
    	return municipioDTO;
    }
    
    public static List<MunicipioDTO> fromEntity(List<Municipio> municipios) {
    	ArrayList<MunicipioDTO> municipiosDTO = new ArrayList<MunicipioDTO>();
    	
    	for(Municipio municipio : municipios) {
    		municipiosDTO.add(MunicipioDTO.fromEntity(municipio));
    	}
    	
        return municipiosDTO;
    }
}
