package com.example.demo.controllers;

import com.example.demo.DTO.EvidenciaDTO;
import com.example.demo.DTO.EvidenciaRequestDTO;
import com.example.demo.entities.Evidencia;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.EvidenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencia")
public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;

    @GetMapping
    public ResponseEntity<List<EvidenciaDTO>> listarEvidencias(@RequestParam(required = false) Long sesionId) {
    	if(sesionId!=null) {
    		List<Evidencia> evidencias = evidenciaService.listarEvidenciasPorSesion(sesionId);
            return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencias));
    	}else{
    		List<Evidencia> evidencias = evidenciaService.listarEvidencias();
            return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencias));
    	}
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenciaDTO> obtenerEvidencia(@PathVariable Long id) throws ResourceNotFoundException {
        Evidencia evidencia = evidenciaService.buscarEvidencia(id);
        return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
    }

    @PostMapping
    public ResponseEntity<EvidenciaDTO> crearEvidencia(@RequestBody EvidenciaRequestDTO evidenciaRequestDTO) throws ResourceNotFoundException {
        Evidencia evidencia = evidenciaRequestDTO.toEntity();
        evidencia = evidenciaService.crearEvidencia(evidencia);
        return ResponseEntity.status(201).body(EvidenciaDTO.fromEntity(evidencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvidenciaDTO> actualizarEvidencia(@PathVariable Long id, @RequestBody EvidenciaRequestDTO evidenciaRequestDTO) throws ResourceNotFoundException {
        Evidencia evidencia = evidenciaRequestDTO.toEntity();
        evidencia.setId(id);
        evidencia = evidenciaService.actualizarEvidencia(evidencia);
        return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EvidenciaDTO> eliminarEvidencia(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Evidencia evidencia = evidenciaService.eliminarEvidencia(id);
        return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
    }
}
