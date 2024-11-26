package com.example.demo.DTO;

import com.example.demo.entities.Taller;

import lombok.Data;

@Data
public class TallerRequestDTO {
    private String nombre;
    private String descripcion;

    public Taller toEntity() {
        Taller taller = new Taller();
        taller.setNombre(this.nombre);
        taller.setDescripcion(this.descripcion);

        return taller;
    }
}
