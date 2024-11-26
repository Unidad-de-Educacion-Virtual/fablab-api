package com.example.demo.DTO;

import com.example.demo.entities.Evidencia;
import com.example.demo.entities.Sesion;

import lombok.Data;

@Data
public class EvidenciaRequestDTO {
    private Long sesionId;
    private String observacion;
    private String url;
    
    public Evidencia toEntity() {
        Evidencia evidencia = new Evidencia();

        if (sesionId != null) {
            Sesion sesion = new Sesion();
            sesion.setId(sesionId);
            evidencia.setSesion(sesion);
        }

        evidencia.setObservacion(this.observacion);
        evidencia.setUrl(this.url);
        
        return evidencia;
    }
}
