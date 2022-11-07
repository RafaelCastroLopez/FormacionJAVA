package com.example.ProyectoCloud.client.application;

import com.example.ProyectoCloud.client.domain.Client;
import com.example.ProyectoCloud.client.infraestructure.controller.inputDTO.ClientInputDTO;
import com.example.ProyectoCloud.client.infraestructure.controller.outputDTO.ClientOutputDTO;
import com.example.ProyectoCloud.client.infraestructure.repository.ClientRepository;
import com.example.ProyectoCloud.exceptions.EntityNotFoundException;
import com.example.ProyectoCloud.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientOutputDTO createClient(ClientInputDTO clientInputDTO) throws Exception {

        if(clientInputDTO.getName() == null)
            throw new UnprocessableEntityException("debe rellenar el nombre", 422);
        if(clientInputDTO.getSurname() == null)
            throw new UnprocessableEntityException("debe rellenar los apellidos", 422);
        if(clientInputDTO.getAge() == null)
            throw new UnprocessableEntityException("debe poner una edad", 422);
        if(clientInputDTO.getEmail() == null)
            throw new UnprocessableEntityException("debe escribir un email", 422);
        if(clientInputDTO.getTelephone() == null)
            throw new UnprocessableEntityException("debe escribir un telefono", 422);

        Client client = clientInputDTO.inputToClient();
        clientRepository.save(client);
        return new ClientOutputDTO(client);
    }

    @Override
    public ClientOutputDTO updateClient(ClientInputDTO clientInputDTO, int id_client) throws Exception {

        if(clientInputDTO.getName() == null)
            throw new UnprocessableEntityException("debe rellenar el nombre", 422);
        if(clientInputDTO.getSurname() == null)
            throw new UnprocessableEntityException("debe rellenar los apellidos", 422);
        if(clientInputDTO.getAge() == null)
            throw new UnprocessableEntityException("debe poner una edad", 422);
        if(clientInputDTO.getEmail() == null)
            throw new UnprocessableEntityException("debe escribir un email", 422);
        if(clientInputDTO.getTelephone() == null)
            throw new UnprocessableEntityException("debe escribir un telefono", 422);

        Optional<Client> clientOptional = clientRepository.findById(id_client);

        if(clientOptional.isEmpty())
            throw new EntityNotFoundException("no se ha encontrado ningun cliente con este id", 404);

        Client client = clientOptional.get();

        client.setName(clientInputDTO.name);
        client.setSurname(clientInputDTO.surname);
        client.setAge(clientInputDTO.age);
        client.setEmail(clientInputDTO.email);
        client.setTelephone(clientInputDTO.telephone);

        clientRepository.save(client);
        return new ClientOutputDTO(client);
    }

    @Override
    public String deleteClient(int id_client) throws Exception {

        Optional<Client> clientOptional = clientRepository.findById(id_client);

        if(clientOptional.isEmpty())
            throw new EntityNotFoundException("no se ha encontrado ningun cliente con este id", 404);

        clientRepository.deleteById(id_client);

        return "el cliente a sido eliminado";
    }

    @Override
    public ClientOutputDTO findClientById(int id_client) throws EntityNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(id_client);

        if(clientOptional.isEmpty())
            throw new EntityNotFoundException("no se ha encontrado ningun cliente con este id", 404);

        Client client = clientOptional.get();

        return new ClientOutputDTO(client);
    }

    @Override
    public List<ClientOutputDTO> findAllClient() {

        List<Client> clientList = clientRepository.findAll();

        List<ClientOutputDTO> clientOutputDTOList;

        clientOutputDTOList = clientList.stream().map(ClientOutputDTO::new).toList();

        return clientOutputDTOList;
    }
}

