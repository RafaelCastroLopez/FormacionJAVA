package com.example.examenJPA.lineasFra.infraestructure.repository;

import com.example.examenJPA.lineasFra.domain.LineasFra;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface LineasFraRepository extends JpaRepository<LineasFra, Integer> {
}
