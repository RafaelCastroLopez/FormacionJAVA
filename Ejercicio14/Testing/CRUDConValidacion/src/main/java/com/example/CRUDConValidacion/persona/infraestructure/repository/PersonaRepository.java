package com.example.CRUDConValidacion.persona.infraestructure.repository;

import com.example.CRUDConValidacion.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    List<Persona> findByName(String name);
}
