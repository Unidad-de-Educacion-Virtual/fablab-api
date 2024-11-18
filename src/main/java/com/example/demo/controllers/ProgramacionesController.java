package com.example.demo.controllers;
import com.example.demo.entities.Programacion;
import com.example.demo.services.ProgramacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programaciones")
public class ProgramacionesController {

    private final ProgramacionesService programacionesService;

    public ProgramacionesController(ProgramacionesService programacionesService) {
        this.programacionesService = programacionesService;
    }

    @GetMapping
    public List<Programacion> listarProgramaciones() {
        return programacionesService.listarProgramaciones();
    }

    @PostMapping
    public ResponseEntity<Programacion> crearProgramacion(@RequestBody Programacion programacion) {
        return ResponseEntity.ok(programacionesService.crearProgramacion(programacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programacion> actualizarProgramacion(@PathVariable Long id, @RequestBody Programacion programacion) {
        return programacionesService.actualizarProgramacion(id, programacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
