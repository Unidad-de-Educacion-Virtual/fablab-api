package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Evidencia;

import lombok.Data;

@Data
public class EvidenciaDTO {
    private Long id;
    private SesionMiniumDTO sesion;
    private String observacion;
    private String url;
    private String fecha;

    public static EvidenciaDTO fromEntity(Evidencia evidencia) {
        EvidenciaDTO evidenciaDTO = new EvidenciaDTO();
        evidenciaDTO.setId(evidencia.getId());
        evidenciaDTO.setObservacion(evidencia.getObservacion());
        evidenciaDTO.setUrl(evidencia.getUrl());
        evidenciaDTO.setFecha(evidencia.getFecha().toString());

        if (evidencia.getSesion() != null) {
            evidenciaDTO.setSesion(SesionMiniumDTO.fromEntity(evidencia.getSesion()));
        }

        return evidenciaDTO;
    }

    public static List<EvidenciaDTO> fromEntity(List<Evidencia> evidencias) {
        ArrayList<EvidenciaDTO> evidenciasDTO = new ArrayList<>();
        
        for (Evidencia evidencia : evidencias) {
            evidenciasDTO.add(EvidenciaDTO.fromEntity(evidencia));
        }
        
        return evidenciasDTO;
    }
}
