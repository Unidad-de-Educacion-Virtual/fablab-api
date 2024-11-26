package com.example.demo.DTO;

import com.example.demo.entities.Ubicacion;

import lombok.Data;

@Data
public class UbicacionRequestDTO {
    private String nombre;

    public Ubicacion toEntity() {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setNombre(this.nombre);

        return ubicacion;
    }
}
