package com.example.ProyectoCloud.trip.application;

import com.example.ProyectoCloud.exceptions.EntityNotFoundException;
import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.infraestructure.controller.inputTripDTO.TripInputDTO;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;

import java.security.PublicKey;

public interface TripService {
    public TripOutputDTO createTrip(TripInputDTO tripInputDTO) throws UnprocessableEntityException;
    public TripOutputDTO updateTrip(Integer id_trip, TripInputDTO tripInputDTO) throws Exception;
    public TripOutputDTO findTripById(Integer id_trip) throws EntityNotFoundException;
    public String deleteTrip(Integer id_trip) throws Exception;
    public TripOutputDTO addPassenger(Integer id_trip, Integer id_passenger) throws UnprocessableEntityException;
    public Integer getTotalPassenger(Integer id_trip) throws UnprocessableEntityException;
    public TripOutputDTO changeStatusTrip(Integer id_trip, Boolean status) throws UnprocessableEntityException;
    public Boolean getTripStatus(Integer id_trip) throws UnprocessableEntityException;

}
