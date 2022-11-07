package com.example.BackFrontend.client.domain;

import com.example.BackFrontend.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    public Integer id_client;

    public String name;

    public String surname;

    public Integer age;

    public String email;

    public Integer telephone;

    public Trip trip;


}
