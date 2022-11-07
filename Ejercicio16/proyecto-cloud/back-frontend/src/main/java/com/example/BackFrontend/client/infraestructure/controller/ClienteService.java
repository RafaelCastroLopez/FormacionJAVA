package com.example.BackFrontend.client.infraestructure.controller;

import com.example.BackFrontend.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(name = "ClientService", url = "http://localhost:8080")
public interface ClienteService {

    @GetMapping("/client/get/{id}")
    public ClientOutputDTO findById(URI baseUrl, @PathVariable Integer id);

}
