package com.example.CRUDConValidacion.persona.infraestructure.repository;

import com.example.CRUDConValidacion.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    @Query
    List<Persona> findByName(String name);
}
