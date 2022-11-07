package com.example.BackFrontend.Ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    public Integer id_ticket;
    public Integer id_client;
    public String nameClient;
    public String lastnameClient;
    public String emailClient;
    public String tripOrigin;
    public String tripDestination;
    public Date departureDate;
    public Date arrivalDate;

    public Ticket(Integer id_client, String nameClient, String lastnameClient, String emailClient,
                  String tripOrigin, String tripDestination, Date departureDate, Date arrivalDate){
        setId_client(id_client);
        setNameClient(nameClient);
        setLastnameClient(lastnameClient);
        setEmailClient(emailClient);
        setTripOrigin(tripOrigin);
        setTripDestination(tripDestination);
        setDepartureDate(departureDate);
        setArrivalDate(arrivalDate);
    }
}
