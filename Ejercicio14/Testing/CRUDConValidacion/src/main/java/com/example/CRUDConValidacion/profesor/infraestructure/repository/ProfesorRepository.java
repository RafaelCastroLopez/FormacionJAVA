package com.example.CRUDConValidacion.profesor.infraestructure.repository;

import com.example.CRUDConValidacion.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
