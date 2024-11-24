package com.example.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.DTO.UbicacionRequestDTO;
import com.example.demo.entities.Ubicacion;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.UbicacionService;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {
private final UbicacionService ubicacionService;
	
	public UbicacionController(UbicacionService ubicacionService){
		this.ubicacionService = ubicacionService;
	}
	
	@GetMapping
    public List<Ubicacion> listarUbicacion() {
        return ubicacionService.listarUbicacion();
    }
    
    @GetMapping("/{id}")
    public UbicacionDTO getUbicacion(@PathVariable Long id) throws Exception {
        try {
        	Ubicacion ubicacion = ubicacionService.buscarUbicacion(id);
        	return new UbicacionDTO(ubicacion.getId(), ubicacion.getNombre());
		} catch (Exception e) {
			throw new ResourceNotFoundException("El ubicacion con id " + id + " no existe.");
		}
    }
   
    @PostMapping
    public ResponseEntity<Ubicacion> crearUbicacion(@RequestBody UbicacionRequestDTO ubicacionRequestDTO) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setNombre(ubicacionRequestDTO.getNombre());
        return ResponseEntity.ok(ubicacionService.crearUbicacion(ubicacion));
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> actualizarUbicacion(@PathVariable Long id, @RequestBody UbicacionRequestDTO ubicacionRequestDTO) {
        return ubicacionService.actualizarUbicacion(id, ubicacionRequestDTO.getNombre())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Ubicacion> eliminarUbicacion(@PathVariable Long id) {
        return ubicacionService.eliminarUbicacion(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
