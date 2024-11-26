package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Asistente;

public interface AsistenteRepository extends JpaRepository<Asistente, Long> {

	List<Asistente> findBySesionId(Long sesionId);

}
