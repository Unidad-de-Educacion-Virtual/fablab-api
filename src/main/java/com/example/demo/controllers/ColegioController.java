package com.example.demo.controllers;

import com.example.demo.DTO.ColegioDTO;
import com.example.demo.DTO.ColegioRequestDTO;
import com.example.demo.entities.Colegio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.ColegioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @GetMapping
    public ResponseEntity<List<ColegioDTO>> listarColegios() {
        List<Colegio> colegios = colegioService.listarColegios();
        return ResponseEntity.ok(ColegioDTO.fromEntity(colegios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColegioDTO> obtenerColegio(@PathVariable Long id) throws ResourceNotFoundException {
        Colegio colegio = colegioService.buscarColegio(id);
        return ResponseEntity.ok(ColegioDTO.fromEntity(colegio));
    }

    @PostMapping
    public ResponseEntity<ColegioDTO> crearColegio(@RequestBody ColegioRequestDTO colegioRequestDTO) {
        Colegio colegio = colegioRequestDTO.toEntity();
        colegio = colegioService.crearColegio(colegio);
        return ResponseEntity.status(201).body(ColegioDTO.fromEntity(colegio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColegioDTO> actualizarColegio(@PathVariable Long id, @RequestBody ColegioRequestDTO colegioRequestDTO) throws ResourceNotFoundException {
        Colegio colegio = colegioRequestDTO.toEntity();
        colegio.setId(id);
        colegio = colegioService.actualizarColegio(colegio);
        return ResponseEntity.ok(ColegioDTO.fromEntity(colegio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ColegioDTO> eliminarColegio(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Colegio colegio = colegioService.eliminarColegio(id);
        return ResponseEntity.ok(ColegioDTO.fromEntity(colegio));
    }
}
