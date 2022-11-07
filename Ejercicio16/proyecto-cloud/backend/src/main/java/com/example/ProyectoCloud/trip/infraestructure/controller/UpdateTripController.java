package com.example.ProyectoCloud.trip.infraestructure.controller;

import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.application.TripService;
import com.example.ProyectoCloud.trip.infraestructure.controller.inputTripDTO.TripInputDTO;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/trip")
public class UpdateTripController {

    @Autowired
    TripService tripService;

    @PutMapping("/update/{id}")
    public TripOutputDTO updateTrip(@RequestBody TripInputDTO tripInputDTO, @PathVariable Integer id) throws Exception {
        return tripService.updateTrip(id, tripInputDTO);
    }

    @PutMapping("/{id_trip}/{status}")
    public TripOutputDTO updateTripStatus(@PathVariable Integer id_trip, @PathVariable Boolean status) throws UnprocessableEntityException {
        return tripService.changeStatusTrip(id_trip, status);
    }
}
