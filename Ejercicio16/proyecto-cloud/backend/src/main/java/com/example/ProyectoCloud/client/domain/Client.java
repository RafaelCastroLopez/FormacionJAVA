package com.example.ProyectoCloud.client.domain;

import com.example.ProyectoCloud.trip.domain.Trip;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    public Integer id_client;

    public String name;

    public String surname;

    public Integer age;

    public String email;

    public Integer telephone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trip")
    @JsonBackReference
    public Trip trip;

}
