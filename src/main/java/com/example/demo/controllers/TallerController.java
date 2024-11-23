package com.example.demo.controllers;
import com.example.demo.DTO.TallerDTO;
import com.example.demo.entities.Taller;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.TallerService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taller")
public class TallerController {

    private final TallerService tallerService;

    public TallerController(TallerService tallerService) {
        this.tallerService = tallerService;
    }

    @GetMapping
    public List<Taller> listarTaller() {
        return tallerService.listarTaller();
    }
    
    @GetMapping("/{id}")
    public TallerDTO getTaller(@PathVariable Long id) throws Exception {
        try {
        	Taller taller = tallerService.buscarTaller(id);
        	return new TallerDTO(taller.getId(), taller.getNombre(), taller.getDescripcion());
		} catch (Exception e) {
			throw new ResourceNotFoundException("El taller con id " + id + " no existe.");
		}
    }
   
    @PostMapping
    public ResponseEntity<Taller> crearTaller(@RequestBody Taller taller) {
        return ResponseEntity.ok(tallerService.crearTaller(taller));
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Taller> actualizarTaller(@PathVariable Long id, @RequestBody Taller taller) {
        return tallerService.actualizarTaller(id, taller)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTaller(@PathVariable Long id) {
        tallerService.eliminarTaller(id);
        return ResponseEntity.noContent().build();
    }
}
