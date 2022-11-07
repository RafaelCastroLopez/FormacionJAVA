package com.example.ProyectoCloud.trip.domain;

import com.example.ProyectoCloud.client.domain.Client;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue
    public Integer id_trip;

    public String origin;

    public String destination;

    public Date departureDate;

    public Date arrivalDate;

    @OneToMany(mappedBy = "trip")
    @JsonManagedReference
    public List<Client> passengers = new ArrayList<>();

    public Boolean status;
}
