package com.example.demo.services;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceReferencedByOthersException;
import com.example.demo.repositories.InstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RolService rolService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Instructor buscarInstructor(Long id) throws ResourceNotFoundException {
        this.showErrorIfNotExist(id);
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        return instructor.get();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Transactional
    public Instructor crearInstructor(Instructor instructor) {
    	User user = instructor.getUser();
    	Rol rol = rolService.buscarRol("INSTRUCTOR");
    	user.setRol(rol);
    	user.setInstructor(instructor);
    	
       	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return instructorRepository.save(instructor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Instructor actualizarInstructor(Instructor instructor) throws ResourceNotFoundException {
        this.showErrorIfNotExist(instructor.getId());
        
        Instructor instructorDb = instructorRepository.findById(instructor.getId()).get();
        
        userService.showErrorIfNotExist(instructorDb.getUser());
        
        User user = instructor.getUser();
        user.setId(instructorDb.getUser().getId());
        user.setRol(instructorDb.getUser().getRol());
        user.setInstructor(instructor);
        
        if(instructor.getUser().getPassword() != null) {
           	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(instructor.getUser().getPassword());
            
            instructor.getUser().setPassword(hashedPassword);
        }
        
        return instructorRepository.save(instructor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Instructor eliminarInstructor(Long id) throws ResourceNotFoundException, ResourceReferencedByOthersException {
        this.showErrorIfNotExist(id);
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        try {
            instructorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceReferencedByOthersException("El instructor no se puede eliminar porque está siendo utilizado en otras entidades.");
        }
        
        return instructor.get();
    }

    public void showErrorIfNotExist(Instructor instructor) throws ResourceNotFoundException {
        if (instructor == null || instructor.getId() == null) {
            throw new ResourceNotFoundException("El instructor no existe.");
        }
        showErrorIfNotExist(instructor.getId());
    }

    public void showErrorIfNotExist(Long id) throws ResourceNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        
        if (instructor.isEmpty()) {
            throw new ResourceNotFoundException("El instructor con id " + id + " no existe.");
        }
    }
}
