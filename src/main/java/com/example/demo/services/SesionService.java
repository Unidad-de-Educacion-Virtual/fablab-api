package com.example.demo.services;

import com.example.demo.entities.Sesion;

import com.example.demo.exceptions.ResourceAlreadyExistException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.SesionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private UbicacionService ubicacionService;

    public Sesion buscarSesion(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Sesion> sesion = sesionRepository.findById(id);
        return sesion.get();
    }

    public List<Sesion> listarSesiones() {
        return sesionRepository.findAll();
    }

    public Sesion crearSesion(Sesion sesion) throws ResourceAlreadyExistException, ResourceNotFoundException {
        this.showErrorIfExist(sesion);

        programacionService.showErrorIfNotExist(sesion.getProgramacion());
        instructorService.showErrorIfNotExist(sesion.getInstructor());
        ubicacionService.showErrorIfNotExist(sesion.getUbicacion());

        return sesionRepository.save(sesion);
    }

    public Sesion actualizarSesion(Sesion sesion) throws ResourceNotFoundException {
        this.showErrorIfNotExist(sesion);

        programacionService.showErrorIfNotExist(sesion.getProgramacion());
        instructorService.showErrorIfNotExist(sesion.getInstructor());
        ubicacionService.showErrorIfNotExist(sesion.getUbicacion());

        return sesionRepository.save(sesion);
    }

    public Sesion eliminarSesion(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Sesion> sesion = sesionRepository.findById(id);

        try {
            sesionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("La sesión no puede eliminarse porque está referenciada por otras entidades.");
        }

        return sesion.get();
    }

    public void showErrorIfNotExist(Sesion sesion) throws ResourceNotFoundException {
        if (sesion == null) {
            throw new ResourceNotFoundException("La sesión no existe.");
        }
        showErrorIfNotExist(sesion.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Sesion> sesion = sesionRepository.findById(id);

        if (sesion.isEmpty()) {
            throw new ResourceNotFoundException("La sesión con id " + id + " no existe.");
        }
    }

    public void showErrorIfExist(Sesion sesion) throws ResourceAlreadyExistException {
        showErrorIfExist(sesion.getId());
    }

    public void showErrorIfExist(Long id) throws ResourceAlreadyExistException {
        Optional<Sesion> sesion = sesionRepository.findById(id);

        if (sesion.isPresent()) {
            throw new ResourceAlreadyExistException("La sesión con id " + id + " ya existe.");
        }
    }
}
