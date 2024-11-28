package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DTO.EvidenciaDTO;
import com.example.demo.DTO.EvidenciaRequestDTO;
import com.example.demo.entities.Evidencia;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.EvidenciaService;
import com.example.demo.services.FileService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/evidencia")
public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;
    
	@Autowired
	private FileService fileService;
    
    @GetMapping
    public ResponseEntity<List<EvidenciaDTO>> listarEvidencias(@RequestParam(required = false) Long sesionId) {
    	if(sesionId!=null) {
    		List<Evidencia> evidencias = evidenciaService.listarEvidenciasPorSesion(sesionId);
            return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencias));
    	} else{
    		List<Evidencia> evidencias = evidenciaService.listarEvidencias();
            return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencias));
    	}
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenciaDTO> obtenerEvidencia(@PathVariable Long id) throws ResourceNotFoundException {
        Evidencia evidencia = evidenciaService.buscarEvidencia(id);
        return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
    }
    
	@PostMapping
	private ResponseEntity<EvidenciaDTO> crearEvidencia(@ModelAttribute EvidenciaRequestDTO evidenciaRequestDTO, @RequestParam("file") MultipartFile file) throws Exception {
		Evidencia evidencia = evidenciaRequestDTO.toEntity();
		String path = fileService.uploadFile(file);
		evidencia.setUrl(path);
		evidencia = evidenciaService.crearEvidencia(evidencia);
		
		return ResponseEntity.status(201).body(EvidenciaDTO.fromEntity(evidencia));
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<EvidenciaDTO> actualizarEvidencia(@PathVariable Long id, @ModelAttribute EvidenciaRequestDTO evidenciaRequestDTO,  @RequestParam(required = false) MultipartFile file) throws Exception {
		Evidencia evidencia = evidenciaRequestDTO.toEntity();
		evidencia.setId(id);
		
		String oldFileName = evidenciaService.buscarEvidencia(id).getUrl();
		
		if(file != null) {
			String path = fileService.uploadFile(file);
			evidencia.setUrl(path);
		} else {
			evidencia.setUrl(oldFileName);
		}
		
		evidencia = evidenciaService.actualizarEvidencia(evidencia);
		
		if(file != null) {
			fileService.deleteFile(oldFileName);
		}
		
		return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<EvidenciaDTO> eliminarEvidencia(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException, IOException {
        Evidencia evidencia = evidenciaService.eliminarEvidencia(id);
        String oldFileName = evidencia.getUrl();
        fileService.deleteFile(oldFileName);
        return ResponseEntity.ok(EvidenciaDTO.fromEntity(evidencia));
    }
}
