package com.example.demo.DTO;

import com.example.demo.entities.Sesion;

import lombok.Data;

@Data
public class SesionMiniumDTO {
    private Long id;

    public static SesionMiniumDTO fromEntity(Sesion sesion) {
        SesionMiniumDTO sesionDTO = new SesionMiniumDTO();
        sesionDTO.setId(sesion.getId());
       
        return sesionDTO;
    }
}
