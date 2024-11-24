package com.example.demo.DTO;

import lombok.Data;

@Data
public class UbicacionDTO {
	private Long id;

    private String nombre;
    public UbicacionDTO(Long id, String nombre) {
    	this.id = id;
    	this.nombre = nombre;
    }
}
