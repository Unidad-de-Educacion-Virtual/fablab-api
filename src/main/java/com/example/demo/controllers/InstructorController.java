package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.DTO.InstructorDTO;
import com.example.demo.DTO.InstructorRequestDTO;
import com.example.demo.entities.Instructor;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.InstructorService;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
	
	private final InstructorService instructorService;
	
	public InstructorController(InstructorService instructorService){
		this.instructorService = instructorService;
	}
	
	@GetMapping
    public List<Instructor> listarInstructor() {
        return instructorService.listarInstructor();
    }
    
    @GetMapping("/{id}")
    public InstructorDTO getInstructor(@PathVariable Long id) throws Exception {
        try {
        	Instructor instructor = instructorService.buscarInstructor(id);
        	return new InstructorDTO(instructor.getId(), instructor.getNombre(), instructor.getDocumento());
		} catch (Exception e) {
			throw new ResourceNotFoundException("El instructor con id " + id + " no existe.");
		}
    }
   
    @PostMapping
    public ResponseEntity<Instructor> crearInstructor(@RequestBody InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = new Instructor();
        instructor.setNombre(instructorRequestDTO.getNombre());
        instructor.setDocumento(instructorRequestDTO.getDocumento());
        return ResponseEntity.ok(instructorService.crearInstructor(instructor));
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Long id, @RequestBody InstructorRequestDTO instructorRequestDTO) {
        return instructorService.actualizarInstructor(id, instructorRequestDTO.getNombre(), instructorRequestDTO.getDocumento())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> eliminarInstructor(@PathVariable Long id) {
        return instructorService.eliminarInstructor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
