package com.example.CRUDConValidacion.student.infraestructure.repository;

import com.example.CRUDConValidacion.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
