package com.example.mongodb.person.infraestructure.repository;

import com.example.mongodb.person.domain.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {
    Page<Persona> findAll(Pageable pageable);
}
