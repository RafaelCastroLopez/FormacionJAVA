package com.example.ProyectoCloud.client.infraestructure.repository;

import com.example.ProyectoCloud.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
