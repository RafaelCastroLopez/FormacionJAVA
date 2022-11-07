package com.example.ProyectoCloud.client.infraestructure.controller;

import com.example.ProyectoCloud.client.application.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class DeleteController {

    @Autowired
    ClientService clientService;

    @DeleteMapping("/delete/{id_client}")
    public String deleteClient(@PathVariable int id_client) throws Exception {
        return clientService.deleteClient(id_client);
    }
}
