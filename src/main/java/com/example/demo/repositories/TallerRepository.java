package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Taller;

public interface TallerRepository extends JpaRepository<Taller, Long> {

}
