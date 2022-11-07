package com.example.ProyectoCloud.trip.infraestructure.controller;

import com.example.ProyectoCloud.exceptions.EntityNotFoundException;
import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.application.TripService;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class FindTripController {

    @Autowired
    TripService tripService;

    @GetMapping("/{id}")
    public TripOutputDTO getTripById(@PathVariable Integer id) throws EntityNotFoundException {
        return tripService.findTripById(id);
    }

    @GetMapping("/verify/{id}")
    public boolean getTripStatus(@PathVariable Integer id) throws UnprocessableEntityException {
        return tripService.getTripStatus(id);
    }
}
