package com.example.examenJPA.cliente.infraestructure.repository;

import com.example.examenJPA.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
