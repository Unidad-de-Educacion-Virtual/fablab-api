package com.example.demo.DTO;

import lombok.Data;

@Data
public class InstructorDTO {
	private long id;
	private String nombre;
	private String documento;
	
	public InstructorDTO(long id, String nombre, String documento) {
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
	}
	
	
}
