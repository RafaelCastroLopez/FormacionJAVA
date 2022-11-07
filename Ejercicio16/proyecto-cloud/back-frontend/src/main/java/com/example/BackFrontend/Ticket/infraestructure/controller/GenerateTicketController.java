package com.example.BackFrontend.Ticket.infraestructure.controller;

import com.example.BackFrontend.Ticket.application.TicketService;
import com.example.BackFrontend.Ticket.infraestructure.controller.outputDTO.TicketOutputDTO;
import com.example.BackFrontend.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateTicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/generateticket/{id_client}/{id_trip}")
    public TicketOutputDTO generateTicket(@PathVariable("id_client") Integer id_client,
                                          @PathVariable("id_trip") Integer id_trip) throws Exception {
        return ticketService.createTicket(id_client, id_trip);
    }
}
