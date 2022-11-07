package com.example.ProyectoCloud.trip.infraestructure.controller;

import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.application.TripService;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class PassengerController {

    @Autowired
    TripService tripService;

    @GetMapping("/passenger/count/{id}")
    public Integer getTotalPassenger(@PathVariable Integer id) throws UnprocessableEntityException {
        return tripService.getTotalPassenger(id);
    }

    @PutMapping("/addpassenger/{id_trip}/{id_client}")
    public TripOutputDTO addPassengerToTravel(@PathVariable Integer id_trip, @PathVariable Integer id_client) throws UnprocessableEntityException {
        return tripService.addPassenger(id_trip, id_client);
    }
}
