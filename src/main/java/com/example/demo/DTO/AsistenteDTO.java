package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Asistente;

import lombok.Data;

@Data
public class AsistenteDTO {
    private Long id;
    private SesionMiniumDTO sesion;
    private ParticipanteMiniumDTO participante;

    public static AsistenteDTO fromEntity(Asistente asistente) {
        AsistenteDTO asistenteDTO = new AsistenteDTO();
        asistenteDTO.setId(asistente.getId());

        if (asistente.getSesion() != null) {
            asistenteDTO.setSesion(SesionMiniumDTO.fromEntity(asistente.getSesion()));
        }
        if (asistente.getParticipante() != null) {
            asistenteDTO.setParticipante(ParticipanteMiniumDTO.fromEntity(asistente.getParticipante()));
        }

        return asistenteDTO;
    }

    public static List<AsistenteDTO> fromEntity(List<Asistente> asistentes) {
        ArrayList<AsistenteDTO> asistentesDTO = new ArrayList<>();
        
        for (Asistente asistente : asistentes) {
            asistentesDTO.add(AsistenteDTO.fromEntity(asistente));
        }
        
        return asistentesDTO;
    }
}
