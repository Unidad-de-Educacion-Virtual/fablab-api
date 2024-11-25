package com.example.demo.controllers;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.DTO.UbicacionRequestDTO;
import com.example.demo.entities.Ubicacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.UbicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<UbicacionDTO>> listarUbicaciones() {
        List<Ubicacion> ubicaciones = ubicacionService.listarUbicaciones();
        return ResponseEntity.ok(UbicacionDTO.fromEntity(ubicaciones));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDTO> obtenerUbicacion(@PathVariable Long id) throws ResourceNotFoundException {
        Ubicacion ubicacion = ubicacionService.buscarUbicacion(id);
        return ResponseEntity.ok(UbicacionDTO.fromEntity(ubicacion));
    }

    @PostMapping
    public ResponseEntity<UbicacionDTO> crearUbicacion(@RequestBody UbicacionRequestDTO ubicacionRequestDTO) throws ResourceNotFoundException {
        Ubicacion ubicacion = ubicacionRequestDTO.toEntity();
        ubicacion = ubicacionService.crearUbicacion(ubicacion);
        return ResponseEntity.status(201).body(UbicacionDTO.fromEntity(ubicacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionDTO> actualizarUbicacion(@PathVariable Long id, @RequestBody UbicacionRequestDTO ubicacionRequestDTO) throws ResourceNotFoundException {
        Ubicacion ubicacion = ubicacionRequestDTO.toEntity();
        ubicacion.setId(id);
        ubicacion = ubicacionService.actualizarUbicacion(ubicacion);
        return ResponseEntity.ok(UbicacionDTO.fromEntity(ubicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UbicacionDTO> eliminarUbicacion(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Ubicacion ubicacion = ubicacionService.eliminarUbicacion(id);
        return ResponseEntity.ok(UbicacionDTO.fromEntity(ubicacion));
    }
}
