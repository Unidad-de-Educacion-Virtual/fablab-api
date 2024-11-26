package com.example.demo.controllers;

import com.example.demo.DTO.ParticipanteDTO;
import com.example.demo.DTO.ParticipanteRequestDTO;
import com.example.demo.entities.Participante;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.services.ParticipanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> listarParticipantes() {
        List<Participante> participantes = participanteService.listarParticipantes();
        return ResponseEntity.ok(ParticipanteDTO.fromEntity(participantes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> obtenerParticipante(@PathVariable Long id) throws ResourceNotFoundException {
        Participante participante = participanteService.buscarParticipante(id);
        return ResponseEntity.ok(ParticipanteDTO.fromEntity(participante));
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO> crearParticipante(@RequestBody ParticipanteRequestDTO participanteRequestDTO) throws ResourceNotFoundException {
        Participante participante = participanteRequestDTO.toEntity();
        participante = participanteService.crearParticipante(participante);
        return ResponseEntity.status(201).body(ParticipanteDTO.fromEntity(participante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> actualizarParticipante(@PathVariable Long id, @RequestBody ParticipanteRequestDTO participanteRequestDTO) throws ResourceNotFoundException {
        Participante participante = participanteRequestDTO.toEntity();
        participante.setId(id);
        participante = participanteService.actualizarParticipante(participante);
        return ResponseEntity.ok(ParticipanteDTO.fromEntity(participante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> eliminarParticipante(@PathVariable Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        Participante participante = participanteService.eliminarParticipante(id);
        return ResponseEntity.ok(ParticipanteDTO.fromEntity(participante));
    }
}
