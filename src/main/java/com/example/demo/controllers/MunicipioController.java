package com.example.demo.controllers;

import com.example.demo.DTO.MunicipioDTO;
import com.example.demo.entities.Municipio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.MunicipioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipio")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping
    public List<Municipio> listarMunicipios() {
        return municipioService.listarMunicipios();
    }

    @GetMapping("/{id}")
    public MunicipioDTO getMunicipio(@PathVariable Long id) throws Exception {
        try {
            Municipio municipio = municipioService.buscarMunicipio(id);
            return new MunicipioDTO(municipio.getId(), municipio.getNombre(), municipio.getDane());
        } catch (Exception e) {
            throw new ResourceNotFoundException("El municipio con id " + id + " no existe.");
        }
    }

    @PostMapping
    public ResponseEntity<Municipio> crearMunicipio(@RequestBody Municipio municipio) {
        return ResponseEntity.ok(municipioService.crearMunicipio(municipio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(@PathVariable Long id, @RequestBody Municipio municipio) {
        return municipioService.actualizarMunicipio(id, municipio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMunicipio(@PathVariable Long id) {
        municipioService.eliminarMunicipio(id);
        return ResponseEntity.noContent().build();
    }
}
