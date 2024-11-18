package com.example.demo.controllers;
import com.example.demo.entities.Taller;
import com.example.demo.services.TalleresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talleres")
public class TalleresController {

    private final TalleresService talleresService;

    public TalleresController(TalleresService talleresService) {
        this.talleresService = talleresService;
    }

    @GetMapping
    public List<Taller> listarTalleres() {
        return talleresService.listarTalleres();
    }

   
    @PostMapping
    public ResponseEntity<Taller> crearTaller(@RequestBody Taller taller) {
        return ResponseEntity.ok(talleresService.crearTaller(taller));
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Taller> actualizarTaller(@PathVariable Long id, @RequestBody Taller taller) {
        return talleresService.actualizarTaller(id, taller)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTaller(@PathVariable Long id) {
        talleresService.eliminarTaller(id);
        return ResponseEntity.noContent().build();
    }
}
