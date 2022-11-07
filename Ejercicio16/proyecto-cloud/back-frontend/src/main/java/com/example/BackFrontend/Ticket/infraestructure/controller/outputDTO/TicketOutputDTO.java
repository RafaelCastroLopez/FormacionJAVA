package com.example.BackFrontend.Ticket.infraestructure.controller.outputDTO;

import com.example.BackFrontend.Ticket.domain.Ticket;
import lombok.Data;

import java.util.Date;

@Data
public class TicketOutputDTO {
    public Integer id_ticket;
    public Integer id_client;
    public String nameClient;
    public String lastnameClient;
    public String emailClient;
    public String tripOrigin;
    public String tripDestination;
    public Date departureDate;
    public Date arrivalDate;

    public TicketOutputDTO(Ticket ticket){
        setId_ticket(ticket.getId_ticket());
        setId_client(ticket.getId_client());
        setNameClient(ticket.getNameClient());
        setLastnameClient(ticket.getLastnameClient());
        setEmailClient(ticket.getEmailClient());
        setTripOrigin(ticket.getTripOrigin());
        setTripDestination(ticket.getTripDestination());
        setDepartureDate(ticket.getDepartureDate());
        setArrivalDate(ticket.getArrivalDate());
    }
}
