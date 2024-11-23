package com.example.demo.DTO;
import lombok.Data;

@Data
public class TallerDTO {
	
	private Long id;
    private String nombre;
    private String descripcion;
	public TallerDTO(Long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
    
}
