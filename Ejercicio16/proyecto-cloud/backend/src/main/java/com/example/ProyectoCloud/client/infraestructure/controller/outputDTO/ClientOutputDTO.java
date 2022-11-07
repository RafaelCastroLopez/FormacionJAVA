package com.example.ProyectoCloud.client.infraestructure.controller.outputDTO;

import com.example.ProyectoCloud.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientOutputDTO {

    public Integer id_client;
    public String name;
    public String surname;
    public Integer age;
    public String email;
    public Integer telephone;
    public ClientOutputDTO(Client client){
        this.id_client=client.getId_client();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.age = client.getAge();
        this.email = client.getEmail();
        this.telephone = client.getTelephone();
    }
}
