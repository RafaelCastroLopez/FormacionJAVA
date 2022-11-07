package com.example.ProyectoCloud.client.infraestructure.controller;

import com.example.ProyectoCloud.client.application.ClientService;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.example.ProyectoCloud.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class GetController {

    @Autowired
    ClientService clientService;

    @GetMapping("/get/{id_client}")
    public ClientOutputDTO getClientById(@PathVariable int id_client) throws EntityNotFoundException {
        return clientService.findClientById(id_client);
    }

    @GetMapping("/getall")
    public List<ClientOutputDTO> getAllClient(){
        return clientService.findAllClient();
    }
}
