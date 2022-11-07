package com.example.ProyectoCloud.client.infraestructure.controller;

import com.example.ProyectoCloud.client.application.ClientService;
import com.example.ProyectoCloud.client.infraestructure.controller.inputDTO.ClientInputDTO;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class CreateController {

    @Autowired
    ClientService clientService;

    @PostMapping("/create")
    public ClientOutputDTO createClient(@RequestBody ClientInputDTO clientInputDTO) throws Exception {
        return clientService.createClient(clientInputDTO);
    }
}
