package com.example.ProyectoCloud.trip.infraestructure.controller;

import com.example.ProyectoCloud.trip.application.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class DeleteTripController {

    @Autowired
    TripService tripService;

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable Integer id) throws Exception {
        return tripService.deleteTrip(id);
    }
}
