package com.example.demo.controllers;

import com.example.demo.DTO.MunicipioDTO;
import com.example.demo.DTO.MunicipioRequestDTO;
import com.example.demo.entities.Municipio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.MunicipioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipio")
public class MunicipioController {

	@Autowired
    private MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> listarMunicipios() {
        List<Municipio> municipios = municipioService.listarMunicipios();
        return ResponseEntity.ok(MunicipioDTO.fromEntity(municipios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> obtenerMunicipio(@PathVariable Long id) throws ResourceNotFoundException {
        Municipio municipio = municipioService.buscarMunicipio(id);
        return ResponseEntity.ok(MunicipioDTO.fromEntity(municipio));
    }

    @PostMapping
    public ResponseEntity<MunicipioDTO> crearMunicipio(@RequestBody MunicipioRequestDTO municipioRequestDTO) {
        Municipio municipio = municipioRequestDTO.toEntity();
        municipio = municipioService.crearMunicipio(municipio);
        return ResponseEntity.status(201).body(MunicipioDTO.fromEntity(municipio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MunicipioDTO> actualizarMunicipio(@PathVariable Long id, @RequestBody MunicipioRequestDTO municipioRequestDTO) throws ResourceNotFoundException {
        Municipio municipio = municipioRequestDTO.toEntity();
        municipio.setId(id);
        municipio = municipioService.actualizarMunicipio(municipio);
        return ResponseEntity.ok(MunicipioDTO.fromEntity(municipio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MunicipioDTO> eliminarMunicipio(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Municipio municipio = municipioService.eliminarMunicipio(id);
        return ResponseEntity.ok(MunicipioDTO.fromEntity(municipio));
    }
}
