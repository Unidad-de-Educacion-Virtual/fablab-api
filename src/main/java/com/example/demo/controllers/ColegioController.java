package com.example.demo.controllers;

import com.example.demo.DTO.ColegioDTO;
import com.example.demo.DTO.ColegioRequestDTO;
import com.example.demo.DTO.MunicipioDTO;
import com.example.demo.entities.Colegio;
import com.example.demo.entities.Municipio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.ColegioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class ColegioController {

    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    @GetMapping
    public List<Colegio> listarColegios() {
        return colegioService.listarColegios();
    }

    @GetMapping("/{id}")
    public ColegioDTO getColegio(@PathVariable Long id) throws Exception {
        try {
        	Colegio colegio = colegioService.buscarColegio(id);
            Municipio municipio = colegio.getMunicipio(); // ManyToOne relación cargada automáticamente

            MunicipioDTO municipioDTO = new MunicipioDTO(
                municipio.getId(),
                municipio.getNombre(),
                municipio.getDane()
            );

            return new ColegioDTO(
                colegio.getId(),
                colegio.getNombre(),
                colegio.getDane(),
                municipioDTO
           );
        } catch (Exception e) {
            throw new ResourceNotFoundException("El colegio con id " + id + " no existe.");
        }
    }


    @PostMapping
    public ResponseEntity<Colegio> crearColegio(@RequestBody ColegioRequestDTO colegioRequestDTO) {
        Colegio colegio = colegioService.crearColegio(
            colegioRequestDTO.getNombre(),
            colegioRequestDTO.getMunicipioId(),
            colegioRequestDTO.getDane()
        );
        return ResponseEntity.ok(colegio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colegio> actualizarColegio(@PathVariable Long id, @RequestBody ColegioRequestDTO colegioRequestDTO) {
        return colegioService.actualizarColegio(
            id,
            colegioRequestDTO.getNombre(),
            colegioRequestDTO.getMunicipioId(),
            colegioRequestDTO.getDane()
        ).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarColegio(@PathVariable Long id) {
        colegioService.eliminarColegio(id);
        return ResponseEntity.noContent().build();
    }
}
