package com.example.BackFrontend.Ticket.application;

import com.example.BackFrontend.Ticket.infraestructure.controller.outputDTO.TicketOutputDTO;
import com.example.BackFrontend.exceptions.EntityNotFoundException;
import com.example.BackFrontend.exceptions.UnprocessableEntityException;

public interface TicketService {
    public TicketOutputDTO createTicket(Integer id_client, Integer id_trip) throws Exception;
}
