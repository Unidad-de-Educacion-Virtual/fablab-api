package com.example.demo.services;

import com.example.demo.entities.Inscripcion;
import com.example.demo.repositories.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionesService {

    private final InscripcionRepository inscripcionRepository;

    public InscripcionesService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public List<Inscripcion> listarInscripcionesPorProgramacion(Long programacionId) {
        return inscripcionRepository.findAllByProgramacionId(programacionId);
    }

    public Inscripcion registrarInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }
}
