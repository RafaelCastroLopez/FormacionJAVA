package com.example.BackFrontend.Ticket.infraestructure.controller.InputDTO;

import lombok.Data;

import java.util.Date;

@Data
public class TicketInputDTO {
    public Integer id_ticket;
    public Integer id_client;
    public String nameClient;
    public String lastnameClient;
    public String emailClient;
    public String tripOrigin;
    public String tripDestination;
    public Date departureDate;
    public Date arrivalDate;
}
