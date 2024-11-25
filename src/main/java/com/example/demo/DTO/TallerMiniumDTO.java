package com.example.demo.DTO;

import com.example.demo.entities.Taller;

import lombok.Data;

@Data
public class TallerMiniumDTO {
    private Long id;
    private String nombre;

    public static TallerMiniumDTO fromEntity(Taller taller) {
        TallerMiniumDTO tallerDTO = new TallerMiniumDTO();
        tallerDTO.setId(taller.getId());
        tallerDTO.setNombre(taller.getNombre());
        
        return tallerDTO;
    }

}
