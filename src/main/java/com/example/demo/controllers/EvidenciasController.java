package com.example.demo.controllers;
import com.example.demo.entities.Evidencia;
import com.example.demo.services.EvidenciasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciasController {

    private final EvidenciasService evidenciasService;

    public EvidenciasController(EvidenciasService evidenciasService) {
        this.evidenciasService = evidenciasService;
    }

    @GetMapping("/{sesionId}")
    public List<Evidencia> listarEvidencias(@PathVariable Long sesionId) {
        return evidenciasService.listarEvidenciasPorSesion(sesionId);
    }

    @PostMapping
    public ResponseEntity<Evidencia> subirEvidencia(@RequestBody Evidencia evidencia) {
        return ResponseEntity.ok(evidenciasService.subirEvidencia(evidencia));
    }
}
