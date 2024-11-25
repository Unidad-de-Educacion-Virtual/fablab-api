package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Ubicacion;

import lombok.Data;

@Data
public class UbicacionDTO {
    private Long id;
    private String nombre;

    public static UbicacionDTO fromEntity(Ubicacion ubicacion) {
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        ubicacionDTO.setId(ubicacion.getId());
        ubicacionDTO.setNombre(ubicacion.getNombre());
        
        return ubicacionDTO;
    }

    public static List<UbicacionDTO> fromEntity(List<Ubicacion> ubicaciones) {
        ArrayList<UbicacionDTO> ubicacionesDTO = new ArrayList<>();
        
        for (Ubicacion ubicacion : ubicaciones) {
            ubicacionesDTO.add(UbicacionDTO.fromEntity(ubicacion));
        }
        
        return ubicacionesDTO;
    }
}
