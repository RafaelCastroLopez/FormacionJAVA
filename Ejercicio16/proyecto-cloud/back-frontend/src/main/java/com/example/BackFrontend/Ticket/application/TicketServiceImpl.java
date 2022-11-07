package com.example.BackFrontend.Ticket.application;

import com.example.BackFrontend.Ticket.domain.Ticket;
import com.example.BackFrontend.Ticket.infraestructure.controller.outputDTO.TicketOutputDTO;
import com.example.BackFrontend.Ticket.infraestructure.repository.TicketRepository;
import com.example.BackFrontend.client.infraestructure.controller.ClienteService;
import com.example.BackFrontend.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.example.BackFrontend.exceptions.EntityNotFoundException;
import com.example.BackFrontend.exceptions.UnprocessableEntityException;
import com.example.BackFrontend.trip.infraestructure.controller.TripService;
import com.example.BackFrontend.trip.infraestructure.controller.outputTripDTO.TripOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TripService tripService;

    @Override
    public TicketOutputDTO createTicket(Integer id_client, Integer id_trip) throws Exception{

        Optional<ServiceInstance> serviceInstance = discoveryClient.getInstances("backend").stream().findFirst();
        URI baseUrl = serviceInstance.orElseThrow(() -> new EntityNotFoundException("no hay servicios disponibles", 404)).getUri();

        ClientOutputDTO clientOutputDTO = clienteService.findById(baseUrl, id_client);
        TripOutputDTO tripOutputDTO = tripService.findById(baseUrl, id_trip);

        if(clientOutputDTO==null)
            throw new EntityNotFoundException("el cliente no existe", 404);
        if(tripOutputDTO==null)
            throw new EntityNotFoundException("el viaje no existe", 404);

        Ticket ticket = new Ticket(clientOutputDTO.getId_client(),clientOutputDTO.getName(), clientOutputDTO.getSurname(), clientOutputDTO.getEmail(),
                tripOutputDTO.getOrigin(), tripOutputDTO.getDestination(), tripOutputDTO.getDepartureDate(), tripOutputDTO.getArrivalDate());

        TripOutputDTO testTrip = tripService.addPassenger(baseUrl, id_trip, id_client);

        if(testTrip == null)
            throw new UnprocessableEntityException("el cliente no esta incluido en este viaje", 422);

        ticketRepository.save(ticket);

        return new TicketOutputDTO(ticket);
    }
}
