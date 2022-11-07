package com.example.BackFrontend.client.infraestructure.controller.inputDTO;

import com.example.BackFrontend.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientInputDTO {

    public String name;

    public String surname;

    public Integer age;

    public String email;

    public Integer telephone;

    public Client inputToClient(){
        Client client = new Client();
        client.setName(this.getName());
        client.setSurname(this.getSurname());
        client.setAge(this.getAge());
        client.setEmail(this.getEmail());
        client.setTelephone(this.getTelephone());
        return client;
    }
}
