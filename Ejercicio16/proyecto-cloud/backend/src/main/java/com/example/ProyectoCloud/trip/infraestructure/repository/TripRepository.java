package com.example.ProyectoCloud.trip.infraestructure.repository;

import com.example.ProyectoCloud.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
