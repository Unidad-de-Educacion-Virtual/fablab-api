package com.example.demo.services;

import com.example.demo.entities.Programacion;
import com.example.demo.repositories.ProgramacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramacionesService {

    private final ProgramacionRepository programacionRepository;

    public ProgramacionesService(ProgramacionRepository programacionRepository) {
        this.programacionRepository = programacionRepository;
    }

    public List<Programacion> listarProgramaciones() {
        return programacionRepository.findAll();
    }

    public Programacion crearProgramacion(Programacion programacion) {
        return programacionRepository.save(programacion);
    }

    public Optional<Programacion> actualizarProgramacion(Long id, Programacion programacionActualizada) {
        return programacionRepository.findById(id).map(programacion -> {
            programacion.setFechaInicio(programacionActualizada.getFechaInicio());
            programacion.setFechaFin(programacionActualizada.getFechaFin());
            programacion.setCantidad(programacionActualizada.getCantidad());
            programacion.setObservacion(programacionActualizada.getObservacion());
            return programacionRepository.save(programacion);
        });
    }
}
