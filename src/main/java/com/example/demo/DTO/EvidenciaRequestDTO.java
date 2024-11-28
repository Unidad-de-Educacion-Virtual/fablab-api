package com.example.demo.DTO;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Evidencia;
import com.example.demo.entities.Sesion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvidenciaRequestDTO {
    private Long sesionId;
    private String observacion;
    private MultipartFile file;
    
    public Evidencia toEntity() {
        Evidencia evidencia = new Evidencia();

        if (sesionId != null) {
            Sesion sesion = new Sesion();
            sesion.setId(sesionId);
            evidencia.setSesion(sesion);
        }

        evidencia.setObservacion(this.observacion);
        
        return evidencia;
    }
}
