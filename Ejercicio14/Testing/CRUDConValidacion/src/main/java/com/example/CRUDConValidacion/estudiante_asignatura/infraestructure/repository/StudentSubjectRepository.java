package com.example.CRUDConValidacion.estudiante_asignatura.infraestructure.repository;

import com.example.CRUDConValidacion.estudiante_asignatura.domain.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, String> {
}
