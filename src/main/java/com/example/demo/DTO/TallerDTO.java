package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Taller;

import lombok.Data;

@Data
public class TallerDTO {
    private Long id;
    private String nombre;
    private String descripcion;

    public static TallerDTO fromEntity(Taller taller) {
        TallerDTO tallerDTO = new TallerDTO();
        tallerDTO.setId(taller.getId());
        tallerDTO.setNombre(taller.getNombre());
        tallerDTO.setDescripcion(taller.getDescripcion());
        
        return tallerDTO;
    }

    public static List<TallerDTO> fromEntity(List<Taller> talleres) {
        ArrayList<TallerDTO> talleresDTO = new ArrayList<>();
        
        for (Taller taller : talleres) {
            talleresDTO.add(TallerDTO.fromEntity(taller));
        }
        
        return talleresDTO;
    }
}
