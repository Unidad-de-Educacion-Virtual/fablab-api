package com.example.demo.services;

import com.example.demo.entities.Colegio;
import com.example.demo.entities.Municipio;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.ColegioRepository;
import com.example.demo.repositories.MunicipioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColegioService {

	 private final ColegioRepository colegioRepository;
	 private final MunicipioRepository municipioRepository; // Repositorio para buscar Municipio

	    public ColegioService(ColegioRepository colegioRepository, MunicipioRepository municipioRepository) {
	        this.colegioRepository = colegioRepository;
	        this.municipioRepository = municipioRepository;
	    }

    public Colegio buscarColegio(long id) {
        return colegioRepository.getReferenceById(id);
    }

    public List<Colegio> listarColegios() {
        return colegioRepository.findAll();
    }

    public Colegio crearColegio(String nombre, Long municipioId, String dane) {
    	Municipio municipio;
    	try {
        	municipio = municipioRepository.getReferenceById(municipioId);
		} catch (Exception e) {
	        throw new ResourceNotFoundException("El municipio con id " + municipioId + " no existe.");
		}
    	Colegio colegio = new Colegio();
        colegio.setNombre(nombre);
        colegio.setMunicipio(municipio);
        colegio.setDane(dane);
        return colegioRepository.save(colegio);
    }


    public Optional<Colegio> actualizarColegio(Long id, String nombre, Long municipioId, String dane) {
        return colegioRepository.findById(id).map(colegio -> {
            Municipio municipio = municipioRepository.findById(municipioId)
                    .orElseThrow(() -> new ResourceNotFoundException("El municipio con id " + municipioId + " no existe."));
            colegio.setNombre(nombre);
            colegio.setMunicipio(municipio);
            colegio.setDane(dane);
            return colegioRepository.save(colegio);
        });
    }

    public void eliminarColegio(Long id) {
        colegioRepository.deleteById(id);
    }
}
