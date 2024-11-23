package com.example.demo.services;

import com.example.demo.entities.Taller;
import com.example.demo.repositories.TallerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TallerService {

    private final TallerRepository tallerRepository;

    public TallerService(TallerRepository tallerRepository) {
        this.tallerRepository = tallerRepository;
    }
    
    public Taller buscarTaller(long id) {
     return tallerRepository.getReferenceById(id);
    } 
    
    public List<Taller> listarTaller() {
        return tallerRepository.findAll();
    }

    public Taller crearTaller(Taller taller) {
        return tallerRepository.save(taller);
    }

    public Optional<Taller> actualizarTaller(Long id, Taller tallerActualizado) {
        return tallerRepository.findById(id).map(taller -> {
            taller.setNombre(tallerActualizado.getNombre());
            taller.setDescripcion(tallerActualizado.getDescripcion());
            return tallerRepository.save(taller);
        });
    }

    public void eliminarTaller(Long id) {
        tallerRepository.deleteById(id);
    }
    
}
