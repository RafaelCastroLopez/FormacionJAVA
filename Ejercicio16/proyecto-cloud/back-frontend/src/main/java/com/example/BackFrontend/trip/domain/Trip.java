package com.example.BackFrontend.trip.domain;

import com.example.BackFrontend.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    public Integer id_trip;

    public String origin;

    public String destination;

    public Date departureDate;

    public Date arrivalDate;

    public List<Client> passengers = new ArrayList<>();

    public Boolean status;
}
