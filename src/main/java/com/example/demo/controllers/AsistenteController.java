package com.example.demo.controllers;

import com.example.demo.DTO.AsistenteDTO;
import com.example.demo.DTO.AsistenteRequestDTO;
import com.example.demo.entities.Asistente;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.AsistenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistente")
public class AsistenteController {

    @Autowired
    private AsistenteService asistenteService;

    @GetMapping
    public ResponseEntity<List<AsistenteDTO>> listarAsistentes() {
        List<Asistente> asistentes = asistenteService.listarAsistentes();
        return ResponseEntity.ok(AsistenteDTO.fromEntity(asistentes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenteDTO> obtenerAsistente(@PathVariable Long id) throws ResourceNotFoundException {
        Asistente asistente = asistenteService.buscarAsistente(id);
        return ResponseEntity.ok(AsistenteDTO.fromEntity(asistente));
    }

    @PostMapping
    public ResponseEntity<AsistenteDTO> crearAsistente(@RequestBody AsistenteRequestDTO asistenteRequestDTO) throws ResourceNotFoundException {
        Asistente asistente = asistenteRequestDTO.toEntity();
        asistente = asistenteService.crearAsistente(asistente);
        return ResponseEntity.status(201).body(AsistenteDTO.fromEntity(asistente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsistenteDTO> actualizarAsistente(@PathVariable Long id, @RequestBody AsistenteRequestDTO asistenteRequestDTO) throws ResourceNotFoundException {
        Asistente asistente = asistenteRequestDTO.toEntity();
        asistente.setId(id);
        asistente = asistenteService.actualizarAsistente(asistente);
        return ResponseEntity.ok(AsistenteDTO.fromEntity(asistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AsistenteDTO> eliminarAsistente(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Asistente asistente = asistenteService.eliminarAsistente(id);
        return ResponseEntity.ok(AsistenteDTO.fromEntity(asistente));
    }
}
