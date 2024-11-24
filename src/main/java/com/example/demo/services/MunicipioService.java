package com.example.demo.services;

import com.example.demo.entities.Municipio;
import com.example.demo.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public Municipio buscarMunicipio(long id) {
        return municipioRepository.getReferenceById(id);
    }

    public List<Municipio> listarMunicipios() {
        return municipioRepository.findAll();
    }

    public Municipio crearMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public Optional<Municipio> actualizarMunicipio(Long id, Municipio municipioActualizado) {
        return municipioRepository.findById(id).map(municipio -> {
            municipio.setNombre(municipioActualizado.getNombre());
            municipio.setDane(municipioActualizado.getDane());
            return municipioRepository.save(municipio);
        });
    }

    public void eliminarMunicipio(Long id) {
        municipioRepository.deleteById(id);
    }
}
