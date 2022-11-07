package com.example.ProyectoCloud.client.infraestructure.controller;

import com.example.ProyectoCloud.client.application.ClientService;
import com.example.ProyectoCloud.client.infraestructure.controller.inputDTO.ClientInputDTO;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class UpdateController {

    @Autowired
    ClientService clientService;

    @PutMapping("/update/{id_client}")
    public ClientOutputDTO updateClient(@RequestBody ClientInputDTO clientInputDTO,
                                        @PathVariable int id_client) throws Exception {
        return clientService.updateClient(clientInputDTO, id_client);
    }
}
