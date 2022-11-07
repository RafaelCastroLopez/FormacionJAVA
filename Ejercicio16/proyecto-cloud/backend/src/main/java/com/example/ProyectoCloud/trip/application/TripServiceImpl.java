package com.example.ProyectoCloud.trip.application;

import com.example.ProyectoCloud.client.domain.Client;
import com.example.ProyectoCloud.client.infraestructure.repository.ClientRepository;
import com.example.ProyectoCloud.exceptions.EntityNotFoundException;
import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import com.example.ProyectoCloud.trip.domain.Trip;
import com.example.ProyectoCloud.trip.infraestructure.controller.inputTripDTO.TripInputDTO;
import com.example.ProyectoCloud.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import com.example.ProyectoCloud.trip.infraestructure.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService{

    @Autowired
    TripRepository tripRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public TripOutputDTO createTrip(TripInputDTO tripInputDTO) throws UnprocessableEntityException {
        if (tripInputDTO.getOrigin()==null)
            throw new UnprocessableEntityException("origin no puede ser null", 422);
        if(tripInputDTO.getDestination() == null)
            throw new UnprocessableEntityException("destination no puede ser null", 422);
        if(tripInputDTO.getStatus() == null)
            throw new UnprocessableEntityException("status no puede ser null", 422);

        tripInputDTO.setArrivalDate(new Date());
        tripInputDTO.setDepartureDate(new Date());

        Trip trip = tripInputDTO.inputToTrip();
        tripRepository.save(trip);
        return new TripOutputDTO(trip);
    }

    @Override
    public TripOutputDTO updateTrip(Integer id_trip, TripInputDTO tripInputDTO) throws Exception{
        if (tripInputDTO.getOrigin()==null)
            throw new UnprocessableEntityException("origin no puede ser null", 422);
        if(tripInputDTO.getDestination() == null)
            throw new UnprocessableEntityException("destination no puede ser null", 422);
        if(tripInputDTO.getStatus() == null)
            throw new UnprocessableEntityException("status no puede ser null", 422);

        tripInputDTO.setArrivalDate(new Date());
        tripInputDTO.setDepartureDate(new Date());

        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new EntityNotFoundException("este viaje no existe", 404);

        Trip trip = optionalTrip.get();
        trip.setOrigin(tripInputDTO.getOrigin());
        trip.setDestination(tripInputDTO.getDestination());
        trip.setDepartureDate(tripInputDTO.getDepartureDate());
        trip.setArrivalDate(tripInputDTO.getArrivalDate());
        trip.setStatus(tripInputDTO.getStatus());

        tripRepository.save(trip);
        return new TripOutputDTO(trip);
    }

    @Override
    public TripOutputDTO findTripById(Integer id_trip) throws EntityNotFoundException {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new EntityNotFoundException("este viaje no existe", 404);

        Trip trip = optionalTrip.get();
        return new TripOutputDTO(trip);
    }

    @Override
    public String deleteTrip(Integer id_trip) throws Exception {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new EntityNotFoundException("este viaje no existe", 404);

        Trip trip = optionalTrip.get();
        if(trip.getPassengers().size() != 0)
            throw new UnprocessableEntityException("el viaje tiene clientes aun", 422);

        tripRepository.delete(trip);
        return "el viaje ha sido borrado";
    }

    @Override
    public TripOutputDTO addPassenger(Integer id_trip, Integer id_passenger) throws UnprocessableEntityException {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        Optional<Client> optionalClient = clientRepository.findById(id_passenger);

        if (optionalTrip.isEmpty())
            throw new UnprocessableEntityException("no existe este viaje", 422);
        if(optionalClient.isEmpty())
            throw new UnprocessableEntityException("este cliente no existe", 422);

        Trip trip = optionalTrip.get();
        Client client = optionalClient.get();

        if(trip.getPassengers().size() >= 40)
            throw new UnprocessableEntityException("el viaje esta lleno", 422);

        client.setTrip(trip);
        clientRepository.save(client);
        trip.getPassengers().add(client);

        return new TripOutputDTO(trip);
    }

    @Override
    public Integer getTotalPassenger(Integer id_trip) throws UnprocessableEntityException {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new UnprocessableEntityException("este viaje no existe", 422);

        Trip trip = optionalTrip.get();

        return trip.getPassengers().size();
    }

    @Override
    public TripOutputDTO changeStatusTrip(Integer id_trip, Boolean status) throws UnprocessableEntityException {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new UnprocessableEntityException("este viaje no existe", 422);

        Trip trip = optionalTrip.get();
        trip.setStatus(status);

        tripRepository.save(trip);

        return new TripOutputDTO(trip);
    }

    @Override
    public Boolean getTripStatus(Integer id_trip) throws UnprocessableEntityException {
        Optional<Trip> optionalTrip = tripRepository.findById(id_trip);
        if(optionalTrip.isEmpty())
            throw new UnprocessableEntityException("este viaje no existe", 422);

        Trip trip = optionalTrip.get();

        return trip.getStatus();
    }
}
