package com.example.demo.controllers;

import com.example.demo.DTO.MunicipioDTO;
import com.example.demo.DTO.MunicipioRequestDTO;
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
    public ResponseEntity<Municipio> crearMunicipio(@RequestBody MunicipioRequestDTO municipioRequestDTO) {
        Municipio municipio = new Municipio();
        municipio.setNombre(municipioRequestDTO.getNombre());
        municipio.setDane(municipioRequestDTO.getDane());
        return ResponseEntity.ok(municipioService.crearMunicipio(municipio));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Municipio> actualizarMunicipio(@PathVariable Long id, @RequestBody MunicipioRequestDTO municipioRequestDTO) {
        return municipioService.actualizarMunicipio(id, municipioRequestDTO.getNombre(), municipioRequestDTO.getDane())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Municipio> eliminarMunicipio(@PathVariable Long id) {
        return municipioService.eliminarMunicipio(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
