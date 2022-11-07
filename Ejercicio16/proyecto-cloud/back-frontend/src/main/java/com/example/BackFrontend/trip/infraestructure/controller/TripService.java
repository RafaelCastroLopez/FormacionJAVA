package com.example.BackFrontend.trip.infraestructure.controller;

import com.example.BackFrontend.trip.domain.Trip;
import com.example.BackFrontend.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.net.URI;

@FeignClient(name = "TripService",  url= "http://localhost:8080")
public interface TripService {

    @GetMapping("/trip/{id}")
    public TripOutputDTO findById(URI baseUrl, @PathVariable Integer id);

    @PutMapping("/trip/addpassenger/{id_trip}/{id_client}")
    public TripOutputDTO addPassenger(URI baseUrl, @PathVariable("id_trip") Integer id_trip,
                                      @PathVariable("id_client") Integer id_client);
}
