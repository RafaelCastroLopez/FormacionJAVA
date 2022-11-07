package com.example.BackFrontend.Ticket.infraestructure.repository;

import com.example.BackFrontend.Ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
