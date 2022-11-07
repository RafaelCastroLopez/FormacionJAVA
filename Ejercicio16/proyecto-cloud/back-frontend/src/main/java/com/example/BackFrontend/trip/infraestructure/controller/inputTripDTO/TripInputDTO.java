package com.example.BackFrontend.trip.infraestructure.controller.inputTripDTO;

import com.example.BackFrontend.trip.domain.Trip;
import lombok.Data;

import java.util.Date;

@Data
public class TripInputDTO {
    public String origin;
    public String destination;
    public Date departureDate;
    public Date arrivalDate;
    public Boolean status;

    public Trip inputToTrip(){
        Trip trip = new Trip();
        trip.setOrigin(this.getOrigin());
        trip.setDestination(this.getDestination());
        trip.setDepartureDate(this.getDepartureDate());
        trip.setArrivalDate(this.getArrivalDate());
        trip.setStatus(this.getStatus());
        return trip;
    }
}
