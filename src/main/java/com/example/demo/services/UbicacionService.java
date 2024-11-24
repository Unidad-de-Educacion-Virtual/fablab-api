package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Ubicacion;
import com.example.demo.repositories.UbicacionRepository;

@Service
public class UbicacionService {
	private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }
    
    public Ubicacion buscarUbicacion(long id) {
     return ubicacionRepository.getReferenceById(id);
    } 
    
    public List<Ubicacion> listarUbicacion() {
        return ubicacionRepository.findAll();
    }

    public Ubicacion crearUbicacion(Ubicacion Ubicacion) {
        return ubicacionRepository.save(Ubicacion);
    }

    public Optional<Ubicacion> actualizarUbicacion(Long id, Ubicacion ubicacionActualizado) {
        return ubicacionRepository.findById(id).map(Ubicacion -> {
            Ubicacion.setNombre(ubicacionActualizado.getNombre());
            return ubicacionRepository.save(Ubicacion);
        });
    }

    public void eliminarUbicacion(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
