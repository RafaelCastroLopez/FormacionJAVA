package com.example.ProyectoCloud.client.application;

import com.example.ProyectoCloud.client.infraestructure.controller.inputDTO.ClientInputDTO;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.example.ProyectoCloud.exceptions.EntityNotFoundException;

import java.util.List;

public interface ClientService {

    public ClientOutputDTO createClient(ClientInputDTO clientInputDTO) throws Exception;

    public ClientOutputDTO updateClient(ClientInputDTO clientInputDTO, int id_client) throws Exception;

    public String deleteClient(int id_client) throws Exception;

    public ClientOutputDTO findClientById(int id_client) throws EntityNotFoundException;

    public List<ClientOutputDTO> findAllClient();
}
