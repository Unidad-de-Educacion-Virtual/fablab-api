package com.example.demo.services;
import com.example.demo.entities.Evidencia;
import com.example.demo.repositories.EvidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenciasService {

    private final EvidenciaRepository evidenciaRepository;

    public EvidenciasService(EvidenciaRepository evidenciaRepository) {
        this.evidenciaRepository = evidenciaRepository;
    }

    public List<Evidencia> listarEvidenciasPorSesion(Long sesionId) {
        return evidenciaRepository.findAllBySesionId(sesionId);
    }

    public Evidencia subirEvidencia(Evidencia evidencia) {
        return evidenciaRepository.save(evidencia);
    }
}
