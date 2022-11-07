package com.example.ProyectoCloud.trip.infraestructure.controller;

import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.application.TripService;
import com.example.ProyectoCloud.trip.infraestructure.controller.inputTripDTO.TripInputDTO;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class CreateTripController {

    @Autowired
    TripService tripService;

    @PostMapping("/create")
    public TripOutputDTO createTrip(@RequestBody TripInputDTO tripInputDTO) throws UnprocessableEntityException {
        return tripService.createTrip(tripInputDTO);
    }
}
