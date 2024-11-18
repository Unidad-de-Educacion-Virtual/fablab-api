package com.example.demo.controllers;

import com.example.demo.entities.Inscripcion;
import com.example.demo.services.InscripcionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {

    private final InscripcionesService inscripcionesService;

    public InscripcionesController(InscripcionesService inscripcionesService) {
        this.inscripcionesService = inscripcionesService;
    }

    @GetMapping("/{programacionId}")
    public List<Inscripcion> listarInscripciones(@PathVariable Long programacionId) {
        return inscripcionesService.listarInscripcionesPorProgramacion(programacionId);
    }

    @PostMapping
    public ResponseEntity<Inscripcion> registrarInscripcion(@RequestBody Inscripcion inscripcion) {
        return ResponseEntity.ok(inscripcionesService.registrarInscripcion(inscripcion));
    }
}
