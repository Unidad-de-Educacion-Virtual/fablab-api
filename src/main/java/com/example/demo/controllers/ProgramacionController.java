package com.example.demo.controllers;

import com.example.demo.DTO.ProgramacionDTO;
import com.example.demo.DTO.ProgramacionRequestDTO;
import com.example.demo.entities.Programacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.ProgramacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programacion")
public class ProgramacionController {

    @Autowired
    private ProgramacionService programacionService;

    @GetMapping
    public ResponseEntity<List<ProgramacionDTO>> listarProgramaciones() {
        List<Programacion> programaciones = programacionService.listarProgramaciones();
        return ResponseEntity.ok(ProgramacionDTO.fromEntity(programaciones));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramacionDTO> obtenerProgramacion(@PathVariable Long id) throws ResourceNotFoundException {
        Programacion programacion = programacionService.buscarProgramacion(id);
        return ResponseEntity.ok(ProgramacionDTO.fromEntity(programacion));
    }

    @PostMapping
    public ResponseEntity<ProgramacionDTO> crearProgramacion(@RequestBody ProgramacionRequestDTO programacionRequestDTO) throws ResourceNotFoundException {
        Programacion programacion = programacionRequestDTO.toEntity();
        programacion = programacionService.crearProgramacion(programacion);
        return ResponseEntity.status(201).body(ProgramacionDTO.fromEntity(programacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramacionDTO> actualizarProgramacion(@PathVariable Long id, @RequestBody ProgramacionRequestDTO programacionRequestDTO) throws ResourceNotFoundException {
        Programacion programacion = programacionRequestDTO.toEntity();
        programacion.setId(id);
        System.out.println(programacion.getObservacion());
        programacion = programacionService.actualizarProgramacion(programacion);
        System.out.println(programacion.getObservacion());
        return ResponseEntity.ok(ProgramacionDTO.fromEntity(programacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramacionDTO> eliminarProgramacion(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Programacion programacion = programacionService.eliminarProgramacion(id);
        return ResponseEntity.ok(ProgramacionDTO.fromEntity(programacion));
    }
    
    @GetMapping("/taller/{tallerId}")
    public ResponseEntity<List<ProgramacionDTO>> listarProgramacionesPorTaller(@PathVariable Long tallerId) {
        List<Programacion> programaciones = programacionService.listarProgramacionesPorTaller(tallerId);
        return ResponseEntity.ok(ProgramacionDTO.fromEntity(programaciones));
    }
}
