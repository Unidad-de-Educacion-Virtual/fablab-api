package com.example.demo.DTO;

import com.example.demo.entities.Colegio;
import com.example.demo.entities.Municipio;

import lombok.Data;

@Data
public class ColegioRequestDTO {
    private String nombre;
    private String dane;
    private Long municipioId;
    
    public Colegio toEntity() {
    	Colegio colegio = new Colegio();
    	colegio.setNombre(this.nombre);
    	colegio.setDane(this.dane);
    	
    	if(municipioId != null) {
        	Municipio municipio = new Municipio();
        	municipio.setId(municipioId);
        	
        	colegio.setMunicipio(municipio);
    	}

		return colegio;
    }
}
