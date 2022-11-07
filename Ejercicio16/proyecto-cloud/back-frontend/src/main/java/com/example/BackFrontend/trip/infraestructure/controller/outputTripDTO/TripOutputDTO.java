package com.example.BackFrontend.trip.infraestructure.controller.outputTripDTO;

import com.example.BackFrontend.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.example.BackFrontend.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripOutputDTO {
    public Integer id_trip;
    public String origin;
    public String destination;
    public Date departureDate;
    public Date arrivalDate;
    public Boolean status;
    public List<ClientOutputDTO> passengers;

    public TripOutputDTO(Trip trip){
        setId_trip(trip.getId_trip());
        setOrigin(trip.getOrigin());
        setDestination(trip.getDestination());
        setDepartureDate(trip.getDepartureDate());
        setArrivalDate(trip.getArrivalDate());
        setStatus(trip.getStatus());
        setPassengers(trip.getPassengers().stream().map(ClientOutputDTO::new).toList());
    }
}
