package com.example.examenJPA.cliente.infraestructure.controller;

import com.example.examenJPA.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteOutputDto {

    int idCliente;
    String nombreCliente;

    public ClienteOutputDto(Cliente cliente){
        setIdCliente(cliente.getIdCliente());
        setNombreCliente(cliente.getNombreCliente());
    }
}
